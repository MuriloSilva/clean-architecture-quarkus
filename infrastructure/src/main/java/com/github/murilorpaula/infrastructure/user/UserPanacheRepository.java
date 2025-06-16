package com.github.murilorpaula.infrastructure.user;

import com.github.murilorpaula.core.user.User;
import com.github.murilorpaula.core.user.UserRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class UserPanacheRepository implements PanacheRepository<UserEntity>, UserRepository {

    @Override
    public User save(User user) {
        UserEntity entity = UserEntity.fromDomain(user);
        persist(entity);
        user.setId(entity.id);
        return user;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return Optional.ofNullable(find("id", id).firstResult()).map(it -> ((UserEntity) it).toDomain());
    }

    @Override
    public List<User> listAllUsers() {
        return streamAll().map(UserEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    public User updateUser(User user) {
        UserEntity entity = UserEntity.fromDomain(user);
        getEntityManager().merge(entity);
        return user;
    }

    @Override
    public void deleteUserById(Long id) {
        delete("id", id);
    }
}
