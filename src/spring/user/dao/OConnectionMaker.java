package spring.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OConnectionMaker implements ConnectionMaker{
    @Override
    public Connection newConnection() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");        
        return DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:xe", "root", "root");
    }
}
