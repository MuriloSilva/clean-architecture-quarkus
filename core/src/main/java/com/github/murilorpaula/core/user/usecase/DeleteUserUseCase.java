package com.github.murilorpaula.core.user.usecase;

import com.github.murilorpaula.core.user.repository.UserRepository;

public class DeleteUserUseCase {
    private final UserRepository repository;

    public DeleteUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public void execute(Long id) {
        repository.deleteUserById(id);
    }
}
