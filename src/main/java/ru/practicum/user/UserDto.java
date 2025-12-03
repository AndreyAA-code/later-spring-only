package ru.practicum.user;

import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@Data
@Builder
public class UserDto {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private Instant registrationDate;
    private UserState state;

}
