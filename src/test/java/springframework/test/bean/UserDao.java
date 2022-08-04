package springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author niu
 */
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "niu1");
        hashMap.put("10002", "niu2");
        hashMap.put("10003", "niu3");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
