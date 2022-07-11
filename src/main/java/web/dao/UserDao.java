package web.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Long> {
    @Query("FROM User u WHERE u.username = :name")
    User getUserByName(@Param("name") String name);
//    List<User> allUsers();
//    void add(User user);
//    void delete(Long id);
//    void edit(User user);
//    User getById(long id);
}
