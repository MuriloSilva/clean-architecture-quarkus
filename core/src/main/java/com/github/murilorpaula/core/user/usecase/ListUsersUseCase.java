package com.github.murilorpaula.core.user.usecase;

import com.github.murilorpaula.core.user.domain.User;
import com.github.murilorpaula.core.user.repository.UserRepository;

import java.util.List;

public class ListUsersUseCase {
    private final UserRepository repository;

    public ListUsersUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> execute() {
        return repository.listAllUsers();
    }
}
