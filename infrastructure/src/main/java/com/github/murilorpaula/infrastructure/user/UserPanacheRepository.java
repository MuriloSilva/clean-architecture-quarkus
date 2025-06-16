package com.github.murilorpaula.infrastructure.user;

import com.github.murilorpaula.core.user.domain.User;
import com.github.murilorpaula.core.user.repository.UserRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class UserPanacheRepository implements PanacheRepository<UserEntity>, UserRepository {

    @Override
    @Transactional
    public User save(User user) {
        UserEntity entity = UserMapper.toEntity(user);
        persist(entity);
        user.setId(entity.id);
        return user;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return Optional.ofNullable(find("id", id).firstResult()).map(it -> UserMapper.toDomain((UserEntity) it));
    }

    @Override
    public List<User> listAllUsers() {
        return streamAll().map(UserMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        UserEntity entity = UserMapper.toEntity(user);
        getEntityManager().merge(entity);
        return user;
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        delete("id", id);
    }
}
