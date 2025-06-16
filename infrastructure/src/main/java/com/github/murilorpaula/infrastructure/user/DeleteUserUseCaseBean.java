package com.github.murilorpaula.infrastructure.user;

import com.github.murilorpaula.core.user.repository.UserRepository;
import com.github.murilorpaula.core.user.usecase.DeleteUserUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DeleteUserUseCaseBean extends DeleteUserUseCase {
    public DeleteUserUseCaseBean() {
        super(null);
    }

    @Inject
    public DeleteUserUseCaseBean(UserRepository repository) {
        super(repository);
    }
}
