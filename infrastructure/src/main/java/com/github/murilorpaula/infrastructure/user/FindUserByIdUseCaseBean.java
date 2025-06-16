package com.github.murilorpaula.infrastructure.user;

import com.github.murilorpaula.core.user.repository.UserRepository;
import com.github.murilorpaula.core.user.usecase.FindUserByIdUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class FindUserByIdUseCaseBean extends FindUserByIdUseCase {
    public FindUserByIdUseCaseBean() {
        super(null);
    }

    @Inject
    public FindUserByIdUseCaseBean(UserRepository repository) {
        super(repository);
    }
}
