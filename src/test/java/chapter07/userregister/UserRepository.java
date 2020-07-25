package chapter07.userregister;

public interface UserRepository {
    void save(User user);
    User findById(String id);
}
