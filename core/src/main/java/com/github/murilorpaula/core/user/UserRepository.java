package com.github.murilorpaula.core.user;

import java.util.List;
import java.util.Optional;

/**
 * Abstraction of user persistence operations.
 */
public interface UserRepository {
    User save(User user);

    Optional<User> findById(Long id);

    List<User> findAll();

    User update(User user);

    void deleteById(Long id);
}
