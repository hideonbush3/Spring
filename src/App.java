import spring.user.dao.UserDao;
import spring.user.domain.User;

public class App {
    public static void main(String[] args) throws Exception {
        String id = "abc123";
        String name = "austin";
        String password = "helloworld";

        User user = new User(id, name, password);
        
        UserDao userDao = new UserDao();

        userDao.add(user);
        
        User savedUser = userDao.get(user.getId());
        
        System.out.printf("회원가입완료\n아이디: %s\n이름: %s\n비밀번호: %s",
            savedUser.getId(),
            savedUser.getName(),
            savedUser.getPassword());
    }
}
