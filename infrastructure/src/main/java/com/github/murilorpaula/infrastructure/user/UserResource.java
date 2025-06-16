package com.github.murilorpaula.infrastructure.user;

import com.github.murilorpaula.core.user.User;
import com.github.murilorpaula.core.user.usecase.UserUseCase;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserUseCase useCase;

    @POST
    public Response create(User user) {
        User created = useCase.create(user);
        return Response.created(URI.create("/users/" + created.getId())).entity(created).build();
    }

    @GET
    public List<User> list() {
        return useCase.findAll();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return useCase.findById(id)
                .map(Response::ok)
                .map(Response.ResponseBuilder::build)
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, User user) {
        User updated = useCase.update(id, user);
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        useCase.delete(id);
    }
}
