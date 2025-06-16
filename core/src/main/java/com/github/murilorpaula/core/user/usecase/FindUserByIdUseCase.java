package com.github.murilorpaula.core.user.usecase;

import com.github.murilorpaula.core.user.domain.User;
import com.github.murilorpaula.core.user.repository.UserRepository;

import java.util.Optional;

public class FindUserByIdUseCase {
    private final UserRepository repository;

    public FindUserByIdUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public Optional<User> execute(Long id) {
        return repository.findUserById(id);
    }
}
