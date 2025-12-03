package ru.practicum.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.practicum.config.AppConfig;
import ru.practicum.config.PersistenceConfig;

import javax.sql.DataSource;
import java.sql.Connection;
import java.time.Instant;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Transactional
@Rollback(false)
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@TestPropertySource(properties = { "jakarta.persistence.jdbc.url=jdbc:postgresql://localhost:5432/test"})
@SpringJUnitConfig({AppConfig.class, PersistenceConfig.class, UserServiceImpl.class})
class UserServiceImplTest {

    private final EntityManager em;
    private final UserService service;

    @Autowired
    private DataSource dataSource;

    @Test
    void testSaveUser() throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            ScriptUtils.executeSqlScript(connection, new ClassPathResource("schema.sql"));
        }
        UserDto userDto = makeUserDto("some@email.com", "Пётр", "Иванов");
        service.saveUser(userDto);

        TypedQuery<User> query = em.createQuery("Select u from User u where u.email = :email", User.class);
        User user = query.setParameter("email", userDto.getEmail())
                .getSingleResult();

        assertThat(user.getId(), notNullValue());
        assertThat(user.getFirstName(), equalTo(userDto.getFirstName()));
        assertThat(user.getLastName(), equalTo(userDto.getLastName()));
        assertThat(user.getEmail(), equalTo(userDto.getEmail()));
        assertThat(user.getState(), equalTo(userDto.getState()));
        assertThat(user.getRegistrationDate(), notNullValue());
    }

    private UserDto makeUserDto(String email, String firstName, String lastName) {
        return UserDto.builder()
                .email(email)
                .firstName(firstName)
                .lastName(lastName)
                .state(UserState.ACTIVE)
                .registrationDate(Instant.now())
                .build();
    }
}