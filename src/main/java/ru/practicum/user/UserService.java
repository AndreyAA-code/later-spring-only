package ru.practicum.user;

import java.util.List;

interface UserService {
    List<UserDto> getAllUsers();
    User saveUser(User user);
}