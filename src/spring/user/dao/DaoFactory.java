package spring.user.dao;

// 팩토리 클래스
// 객체의 생성방법을 결정하고 생성한 객체를 반환하는 클래스
public class DaoFactory {
    public UserDao userDao(){
        return new UserDao(connectionMaker());
    }

    public ConnectionMaker connectionMaker(){
        return new MConnectionMaker();
    }
}
