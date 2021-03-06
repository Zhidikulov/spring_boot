package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    User getUserByName(String name);
    List<User> allUsers();
    void add(User user);
    void delete(Long id);
    void edit(Long id, String username, String password);
    User getById(long id);
}
