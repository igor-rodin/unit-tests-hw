package ru.igorrodin.hw3.users;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    /**
     * Добавляет пользователя, прошедшего аутентификацию
     *
     * @param user Добавляемый пользователь
     */
    public void addUser(User user) {
        if (user.isAuthenticate) {
            data.add(user);
        }
    }

    /**
     * Разлогинивает всех пользователей, кроме администраторов.
     */
    public void unloginAll() {
        data.removeIf(user -> !user.isAdmin());
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.getName().equals(username)) {
                return true;
            }
        }
        return false;
    }


}
