package com.github.murilorpaula.core.user.usecase;

import com.github.murilorpaula.core.user.domain.User;
import com.github.murilorpaula.core.user.repository.UserRepository;

public class UpdateUserUseCase {
    private final UserRepository repository;

    public UpdateUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public User execute(Long id, User user) {
        user.setId(id);
        return repository.updateUser(user);
    }
}
