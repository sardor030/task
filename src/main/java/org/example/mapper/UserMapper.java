package org.example.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.example.dto.UserCreateDto;
import org.example.dto.UserDto;
import org.example.dto.UserUpdateDto;
import org.example.entity.User;
import java.util.List;
@Component
@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<
        User,
        UserDto,
        UserCreateDto,
        UserUpdateDto> {
    @Override
    UserDto toDto(User user);
    @Override
    List<UserDto> toDto(List<User> e);
    @Override
    User fromCreateDto(UserCreateDto userCreateDto);
    @Override
    User fromUpdateDto(UserUpdateDto userUpdateDto);
}
