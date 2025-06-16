package com.github.murilorpaula.core.user.usecase;

import com.github.murilorpaula.core.user.User;
import com.github.murilorpaula.core.user.UserRepository;

import java.util.List;
import java.util.Optional;

/**
 * Encapsula as regras de negócio para operações de usuário.
 */
public class UserUseCase {
    private final UserRepository repository;

    public UserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User user) {
        return repository.save(user);
    }

    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User update(Long id, User user) {
        user.setId(id);
        return repository.update(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
