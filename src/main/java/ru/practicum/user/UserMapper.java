package ru.practicum.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import ru.practicum.item.ItemDto;

@AllArgsConstructor(access = AccessLevel.PRIVATE)

public class UserMapper {
    public static UserDto from(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    public static User from(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        return user;
    }
}
