package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        UserService mainUser = new UserServiceImpl();

        mainUser.createUsersTable();

        mainUser.saveUser("Poll", "Parker", (byte) 65);
        mainUser.saveUser("Biba", "Watter", (byte) 23);
        mainUser.saveUser("Boba", "Sugar", (byte) 49);
        mainUser.saveUser("Sam", "Pik", (byte) 22);

        mainUser.getAllUsers();

        mainUser.cleanUsersTable();

        mainUser.dropUsersTable();
    }
}