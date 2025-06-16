package com.github.murilorpaula.infrastructure.user;

import com.github.murilorpaula.core.user.repository.UserRepository;
import com.github.murilorpaula.core.user.usecase.UpdateUserUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UpdateUserUseCaseBean extends UpdateUserUseCase {
    public UpdateUserUseCaseBean() {
        super(null);
    }

    @Inject
    public UpdateUserUseCaseBean(UserRepository repository) {
        super(repository);
    }
}
