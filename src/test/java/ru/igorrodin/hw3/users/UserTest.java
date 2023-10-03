package ru.igorrodin.hw3.users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user;

    @BeforeEach
    void init() {
        user = new User("user", "psw", false);
    }

    @ParameterizedTest
    @CsvSource({
            "true, user, psw",
            "false, user, psw_1",
            "false, user_1, psw",
    })
    @DisplayName("Проверяет, что зарегистрированный пользователь проходит аутентификацию")
    void authenticate(boolean expectedResult, String userName, String userPassword) {
        assertThat(user.authenticate(userName, userPassword)).isEqualTo(expectedResult);
        assertThat(user.isAuthenticate).isEqualTo(expectedResult);
    }
}