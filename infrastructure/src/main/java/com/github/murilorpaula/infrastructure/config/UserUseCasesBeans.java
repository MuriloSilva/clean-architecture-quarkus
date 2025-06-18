package com.github.murilorpaula.infrastructure.config;

import com.github.murilorpaula.core.user.repository.UserRepository;
import com.github.murilorpaula.core.user.usecase.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

@ApplicationScoped
public class UserUseCasesBeans {

    @Inject
    UserRepository repository;

    @Produces
    public CreateUserUseCase createUserUseCase(UserRepository repository) {
        return new CreateUserUseCase(repository);
    }

    @Produces
    public DeleteUserUseCase deleteUserUseCaseBean(UserRepository repository) {
        return  new DeleteUserUseCase(repository);
    }

    @Produces
    public FindUserByIdUseCase findUserUseCaseBean(UserRepository repository) {
        return  new FindUserByIdUseCase(repository);
    }

    @Produces
    public UpdateUserUseCase updateUserUseCaseBean(UserRepository repository) {
        return  new UpdateUserUseCase(repository);
    }

    @Produces
    public ListUsersUseCase listUsersUseCaseBean(UserRepository repository) {
        return  new ListUsersUseCase(repository);
    }

}
