package tms.storage;

import tms.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {

    private static List<User> userList = new ArrayList<>();

    public void save(User user){
        userList.add(user);
    }

    public User getByUsername(String username){
        return userList.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);
    }

    public boolean existByUsername(String username){
        return userList.stream().anyMatch(user -> user.getUsername().equals(username));
    }

}