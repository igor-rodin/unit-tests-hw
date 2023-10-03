package ru.igorrodin.hw3.users;

import java.util.Objects;

public class User {
    boolean isAuthenticate = false;
    private String name;
    private String password;
    private boolean isAdmin = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    //3.6.

    /**
     * Проверят, что пользователь с именем name и паролем password зарегистрирован
     *
     * @param name     Имя пользователя
     * @param password Пароль пользователя
     * @return Возвращает true если пользователь прошел аутентификацию
     */
    public boolean authenticate(String name, String password) {
        isAuthenticate = name.equals(this.name) && password.equals(this.password);
        return isAuthenticate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }

    public boolean isAdmin() {
        return this.isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isAuthenticate() {
        return isAuthenticate;
    }

    public void setAuthenticate(boolean authenticate) {
        isAuthenticate = authenticate;
    }
}
