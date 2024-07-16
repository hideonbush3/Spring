package spring.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
    public Connection newConnection()throws ClassNotFoundException, SQLException;
}
