package ru.igorrodin.hw3.users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserRepositoryTest {
    private UserRepository repo;
    private User user_1;
    private User user_2;
    private User user_3;

    @BeforeEach
    void init() {
        repo = new UserRepository();
        user_1 = new User("user_1", "psw_1", true);
        user_2 = new User("user_2", "psw_2", false);
        user_3 = new User("user_3", "psw_3", false);
    }

    @DisplayName("Проверяет, что пользователь, прошедший аутентификацию, добавлен в репозиторий")
    @Test
    void addAuthenticatedUser() {
        user_1.setAuthenticate(true);
        repo.addUser(user_1);
        assertThat(repo.findByName(user_1.getName())).isTrue();
    }

    @DisplayName("Проверяет, что пользователь, не прошедший аутентификацию, не добавлен в репозиторий")
    @Test
    void addNonAuthenticatedUser() {
        user_2.setAuthenticate(false);
        repo.addUser(user_1);
        assertThat(repo.findByName(user_2.getName())).isFalse();
    }

    @DisplayName("Проверяет, что разлогинены все пользователи, кроме администраторов")
    @Test
    void unloginAll() {
        user_1.setAuthenticate(true);
        repo.addUser(user_1);
        user_2.setAuthenticate(true);
        repo.addUser(user_2);
        user_3.setAuthenticate(true);
        repo.addUser(user_3);
        repo.unloginAll();
        long adminCountAfter = repo.data.stream().filter(User::isAdmin).count();
        assertThat(repo.data.size()).isEqualTo(adminCountAfter);
    }
}