package com.jardessouza.bookstoremanager.user.mapper;

import com.jardessouza.bookstoremanager.user.dto.UserDTO;
import com.jardessouza.bookstoremanager.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toModel(UserDTO userDTO);
    UserDTO toDTO(User user);
}
