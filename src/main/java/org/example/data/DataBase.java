package org.example.data;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public final class DataBase {
    public static List<User> listUser = new CopyOnWriteArrayList<>();
    public static List<Message> listMessage = new CopyOnWriteArrayList<>();

    private DataBase() {
    }

    public static void init() {
        System.out.println("Установка соединения с Базой Данных");
        listUser.add(new User("Artem", "777", "ArtemName", UserType.ADMIN));
        listUser.add(new User("Danil", "123", "DanilName", UserType.CLIENT));
        listUser.add(new User("Vitalik", "456", "VitalikName", UserType.CLIENT));
    }

    public static void close() {
        System.out.println("Закрытие соединения с Базой Данных");
    }

    public static Optional<User> findUserByLogin(String loginInput) {
        return listUser.stream()
                .filter(user -> user.getLogin().equals(loginInput))
                .findFirst();
    }
}
