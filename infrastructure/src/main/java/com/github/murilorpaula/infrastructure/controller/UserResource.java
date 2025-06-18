package com.github.murilorpaula.infrastructure.controller;

import com.github.murilorpaula.core.user.domain.User;
import com.github.murilorpaula.core.user.usecase.CreateUserUseCase;
import com.github.murilorpaula.core.user.usecase.DeleteUserUseCase;
import com.github.murilorpaula.core.user.usecase.FindUserByIdUseCase;
import com.github.murilorpaula.core.user.usecase.ListUsersUseCase;
import com.github.murilorpaula.core.user.usecase.UpdateUserUseCase;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.net.URI;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "User", description = "Operações de usuário")
public class UserResource {

    @Inject
    CreateUserUseCase createUser;

    @Inject
    ListUsersUseCase listUsers;

    @Inject
    FindUserByIdUseCase findUserById;

    @Inject
    UpdateUserUseCase updateUser;

    @Inject
    DeleteUserUseCase deleteUser;

    @POST
    @Operation(summary = "Cria um novo usuário")
    public Response create(User user) {
        User created = createUser.execute(user);
        return Response.created(URI.create("/users/" + created.getId())).entity(created).build();
    }

    @GET
    @Operation(summary = "Lista todos os usuários")
    public List<User> list() {
        return listUsers.execute();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Busca usuário pelo id")
    public Response findById(@PathParam("id") Long id) {
        return findUserById.execute(id)
                .map(Response::ok)
                .map(Response.ResponseBuilder::build)
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Atualiza os dados de um usuário")
    public Response update(@PathParam("id") Long id, User user) {
        User updated = updateUser.execute(id, user);
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Remove um usuário")
    public void delete(@PathParam("id") Long id) {
        deleteUser.execute(id);
    }
}
