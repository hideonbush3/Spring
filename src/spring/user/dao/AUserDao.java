package spring.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 상속을 통해서 필요에 맞는 커넥션 객체를 알아서 생성한다
// 예를들어, Oracle jdbc 커넥션이 필요하면 또 다른 서브클래스를 작성하면 되고..
public class AUserDao extends UserDao{
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
            "jdbc:mysql://localhost/spring", "root", "root");
    }
}
