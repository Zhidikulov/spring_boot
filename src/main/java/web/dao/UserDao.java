package web.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.model.User;


@Repository
public interface UserDao extends JpaRepository<User,Long> {
    @Query("FROM User u WHERE u.username = :name")
    User getUserByName(@Param("name") String name);
    @Query("UPDATE User u SET u.username = :name, u.password = :password WHERE u.id = :id")
    void edit(@Param("id") Long id, @Param("name") String username, @Param("password") String password);
}
