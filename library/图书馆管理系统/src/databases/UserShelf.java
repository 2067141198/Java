package databases;

import classse.User;

import java.util.*;

//所有有过借书的用户的信息
public class UserShelf {
    List<User> userList = new ArrayList<>();

    static UserShelf instance = new UserShelf();
    public static UserShelf getInstance() {
        return instance;
    }

    public void addNextUser(User user) {
        for(User u : userList) {
            if(u.equals(user))
                return;
        }
        userList.add(user);
    }
}
