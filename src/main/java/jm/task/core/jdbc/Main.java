package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

// класс для проверки подключения к БД и всех методов из UserDaoJDBCImpl
public class Main {
    public static void main(String[] args) {

// connection прописан в каждом методе UserDaoJDBCImpl!!!
        UserDao userDao = new UserDaoJDBCImpl(); // использую реализацию интерфейса UserDao из класса UserDaoJDBCImpl
        final UserService userService = new UserServiceImpl(userDao);

        userService.createUsersTable();

        userService.saveUser("Name1", "LastName1", (byte) 20);
        userService.saveUser("Name2", "LastName2", (byte) 25);
        userService.saveUser("Name3", "LastName3", (byte) 31);
        userService.saveUser("Name4", "LastName4", (byte) 38);

        userService.removeUserById(3);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
