package com.github.murilorpaula.infrastructure.user;

import com.github.murilorpaula.core.user.UserRepository;
import com.github.murilorpaula.core.user.usecase.UserUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

/**
 * CDI bean que expõe {@link UserUseCase} para o restante da aplicação.
 */
@ApplicationScoped
public class UserUseCaseBean extends UserUseCase {

    @Inject
    public UserUseCaseBean(UserRepository repository) {
        super(repository);
    }
}
