package spring.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import spring.user.domain.User;


// 프로그래밍의 기초 개념중에 '관심사의 분리' 라는 것이 있다

// '관심사'란 '해당 코드의 역할or기능' 이라고 해석할 수 있다
// 관심사가 같은것끼리는 하나로 모으고,
// 관심사가 다른것끼리는 서로 영향을 끼치지 않도록 하는게 '관심사의 분리'이다

// 아래 코드도
// 유저정보를 저장, 조회하는 각각의 메서드끼리 중복되는 코드(역할or기능)가 많다

// 관심사가 같은 부분이다
// 이렇게 중복되는 관심사를 빼내서 다른 하나의 
// 클래스로 옮기면 좋은 코드가 완성될 것이다
public class UserDao{
    private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker c){
        this.connectionMaker = c;
    }

    public void add(User user) throws SQLException, ClassNotFoundException{
        Connection c = connectionMaker.newConnection();

        PreparedStatement ps = c.prepareStatement(
            "insert into users(id, name, password) values(?,?,?)"
        );
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();
        
        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException{
        Connection c = connectionMaker.newConnection();
        
        PreparedStatement ps = c.prepareStatement(
            "select * from users where id = (?)"
        );
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }
}
