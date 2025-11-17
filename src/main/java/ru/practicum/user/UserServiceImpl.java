package ru.practicum.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> getAllUsers() {
        return repository.findAll()
                .stream()
                .map(UserMapper::from)
                .collect(Collectors.toList());
    }

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }
}