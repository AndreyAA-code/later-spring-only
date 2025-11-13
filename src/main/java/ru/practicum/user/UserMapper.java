package ru.practicum.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import ru.practicum.item.ItemDto;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)

public class UserMapper {
    public static UserDto from(User user) {
        UserDto userDto = new UserDto();
        String regDate = DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")
                .withZone(ZoneOffset.UTC)
                .format(user.getRegistrationDate());
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setRegistrationDate(regDate);
        userDto.setState(user.getState());
        return userDto;
    }

    public static User from(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setRegistrationDate(userDto.getRegistrationDate());
        user.setState(userDto.getState());
        return user;
    }
}
