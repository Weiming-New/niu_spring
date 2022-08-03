package test.bean;

/**
 * @author niu
 */
public class UserService {

    private String uId;

    private UserDao userDao;

    public void queryUserInfo() {
        System.out.println("query User:" + userDao.queryUserName(uId));
    }

    // ...get/set
}
