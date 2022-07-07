package web.dao;


import web.model.User;

import java.util.List;

public interface UserDao {
    User getUserByName(String name);
    List<User> allUsers();
    void add(User user);
    void delete(Long id);
    void edit(User user);
    User getById(long id);
}
