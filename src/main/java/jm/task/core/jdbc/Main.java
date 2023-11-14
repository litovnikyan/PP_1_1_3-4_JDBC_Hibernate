package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;



public class Main {
        public static void main(String[] args) {
                // реализуйте алгоритм здесь
                UserService userService = new UserServiceImpl();


                userService.createUsersTable();

                userService.saveUser("Poll", "Parker", (byte) 65);
                userService.saveUser("Biba", "Watter", (byte) 23);
                userService.saveUser("Boba", "Sugar", (byte) 49);
                userService.saveUser("Sam", "Pik", (byte) 22);

                userService.getAllUsers();

                userService.cleanUsersTable();

                userService.dropUsersTable();

                Util.factoryClose();

        }
}

