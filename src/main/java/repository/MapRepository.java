package repository;

import java.util.HashMap;
import java.util.Map;

public class MapRepository {
    private static MapRepository instance;
    private static Map<String, String> userList;

    public MapRepository() {
        userList = new HashMap<>();
        userList.put("admin", "admin");
        userList.put("user", "user");
    }

    public static MapRepository getInstance() {
        if (instance == null) {
            instance = new MapRepository();
        }
        return instance;
    }

    public static void addUserToBase(String username, String password) {
        userList.put(username, password);
    }

    public boolean isUsernameContains(String username) {
        return userList.containsKey(username);
    }

    public boolean isUsernameExists(String username) {
        return userList.containsKey(username);
    }

    public boolean isValidCredentials(String username, String password) {
        return userList.containsKey(username) && userList.get(username).equals(password);
    }
}