package com.github.murilorpaula.core.user.usecase;

import com.github.murilorpaula.core.user.domain.User;
import com.github.murilorpaula.core.user.repository.UserRepository;

public class CreateUserUseCase {
    private final UserRepository repository;

    public CreateUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public User execute(User user) {
        return repository.save(user);
    }
}
