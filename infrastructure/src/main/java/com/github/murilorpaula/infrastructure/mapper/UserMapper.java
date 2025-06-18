package com.github.murilorpaula.infrastructure.mapper;

import com.github.murilorpaula.core.user.domain.User;
import com.github.murilorpaula.infrastructure.entity.UserEntity;

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
