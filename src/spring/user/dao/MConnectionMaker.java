package spring.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MConnectionMaker implements ConnectionMaker{
    @Override
    public Connection newConnection() throws ClassNotFoundException, SQLException {  
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
            "jdbc:mysql://localhost/spring", "root", "root");
    }
}
