package com.github.murilorpaula.core.user.repository;

import com.github.murilorpaula.core.user.domain.User;

import java.util.List;
import java.util.Optional;

/**
 * Abstraction of user persistence operations.
 */
public interface UserRepository {
    User save(User user);

    Optional<User> findUserById(Long id);

    List<User> listAllUsers();

    User updateUser(User user);

    void deleteUserById(Long id);
}
