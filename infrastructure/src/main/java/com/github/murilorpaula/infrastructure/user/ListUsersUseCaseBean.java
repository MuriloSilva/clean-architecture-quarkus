package com.github.murilorpaula.infrastructure.user;

import com.github.murilorpaula.core.user.repository.UserRepository;
import com.github.murilorpaula.core.user.usecase.ListUsersUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ListUsersUseCaseBean extends ListUsersUseCase {
    public ListUsersUseCaseBean() {
        super(null);
    }

    @Inject
    public ListUsersUseCaseBean(UserRepository repository) {
        super(repository);
    }
}
