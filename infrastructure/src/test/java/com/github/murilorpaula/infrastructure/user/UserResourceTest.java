package com.github.murilorpaula.infrastructure.user;

import com.github.murilorpaula.core.user.User;
import com.github.murilorpaula.core.user.usecase.UserUseCase;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class UserResourceTest {

    @Inject
    UserUseCase useCase;

    @Test
    void testCrud() {
        // create
        User u = new User(null, "John", "john@test.com");
        User created = useCase.create(u);
        assertNotNull(created.getId());

        // list
        List<User> users = useCase.findAll();
        assertEquals(1, users.size());

        // update
        created.setName("Johnny");
        User updated = useCase.update(created.getId(), created);
        assertEquals("Johnny", updated.getName());

        // delete
        useCase.delete(created.getId());
        assertTrue(useCase.findAll().isEmpty());
    }
}
