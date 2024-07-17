package spring.user;

import java.sql.SQLException;

import spring.user.dao.DaoFactory;
import spring.user.dao.UserDao;
import spring.user.domain.User;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        UserDao userDao = new DaoFactory().userDao();

        User user = userDao.get("abc123");
        System.out.println(user.getName());
    }
}
