package com.github.murilorpaula.infrastructure.user;

import com.github.murilorpaula.core.user.repository.UserRepository;
import com.github.murilorpaula.core.user.usecase.CreateUserUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CreateUserUseCaseBean extends CreateUserUseCase {
    public CreateUserUseCaseBean() {
        super(null);
    }

    @Inject
    public CreateUserUseCaseBean(UserRepository repository) {
        super(repository);
    }
}
