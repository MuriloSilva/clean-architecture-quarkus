package com.github.murilorpaula.infrastructure.user;

import com.github.murilorpaula.core.user.domain.User;

public class UserMapper {
    public static UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.id = user.getId();
        entity.name = user.getName();
        entity.email = user.getEmail();
        return entity;
    }

    public static User toDomain(UserEntity entity) {
        return new User(entity.id, entity.name, entity.email);
    }
}
