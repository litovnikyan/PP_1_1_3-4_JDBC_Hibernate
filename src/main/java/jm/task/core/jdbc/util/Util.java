package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Util {

    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/user";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "DX120Tproject";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DIALECT = "org.hibernate.dialect.MySQLDialect";
    private static Connection connection = null;
    private static SessionFactory sessionFactory = null;

    public static Connection getConnection() {

        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static SessionFactory getSession() {
        Properties properties = new Properties();

        properties.setProperty("hibernate.connection.url", URL);
        properties.setProperty("hibernate.dialect", DIALECT);
        properties.setProperty("hibernate.connection.username", USER_NAME);
        properties.setProperty("hibernate.connection.password", PASSWORD);
        properties.setProperty("hibernate.connection.driver_class", DRIVER);
        sessionFactory = new Configuration()
                .addAnnotatedClass(User.class)
                .addProperties(properties)
                .buildSessionFactory();

        return sessionFactory;
    }

    public static void factoryClose() {
        sessionFactory.close();
    }

}

