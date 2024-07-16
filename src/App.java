import spring.user.dao.UserDao;
import spring.user.dao.MConnectionMaker;
import spring.user.dao.OConnectionMaker;
import spring.user.dao.ConnectionMaker;

public class App {
    public static void main(String[] args) throws Exception {        
        // 1.
        // UserDao userDao = new UserDao((ConnectionMaker) new MConnectionMaker());

        // 2.
        ConnectionMaker c1 = new MConnectionMaker();
        UserDao userDao1 = new UserDao(c1);

        ConnectionMaker c2 = new OConnectionMaker();
        UserDao userDao2 = new UserDao(c2);


    }
}
