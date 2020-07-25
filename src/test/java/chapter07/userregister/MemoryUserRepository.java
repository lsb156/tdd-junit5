package chapter07.userregister;

import java.util.HashMap;
import java.util.Map;

public class MemoryUserRepository implements UserRepository {

    private final Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.getUserId(), user);
    }

    @Override
    public User findById(String id) {
        return users.get(id);
    }
}
