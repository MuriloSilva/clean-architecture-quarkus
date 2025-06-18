package com.github.murilorpaula.infrastructure.controller;

import com.github.murilorpaula.core.user.domain.User;
import com.github.murilorpaula.core.user.usecase.CreateUserUseCase;
import com.github.murilorpaula.core.user.usecase.DeleteUserUseCase;
import com.github.murilorpaula.core.user.usecase.ListUsersUseCase;
import com.github.murilorpaula.core.user.usecase.UpdateUserUseCase;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class UserResourceTest {

    @Inject
    CreateUserUseCase createUser;

    @Inject
    ListUsersUseCase listUsers;

    @Inject
    UpdateUserUseCase updateUser;

    @Inject
    DeleteUserUseCase deleteUser;

    @Test
    void testCrud() {
        // create
        User u = new User(null, "John", "john@test.com");
        User created = createUser.execute(u);
        assertNotNull(created.getId());

        // list
        List<User> users = listUsers.execute();
        assertEquals(1, users.size());

        // update
        created.setName("Johnny");
        User updated = updateUser.execute(created.getId(), created);
        assertEquals("Johnny", updated.getName());

        // delete
        deleteUser.execute(created.getId());
        assertTrue(listUsers.execute().isEmpty());
    }
}
