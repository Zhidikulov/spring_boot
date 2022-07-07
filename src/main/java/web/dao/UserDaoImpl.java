package web.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {


    @Autowired
    private SessionFactory ses;




    @Override
    public User getUserByName(String name) {
        Session session = ses.getCurrentSession();
        User user = session.createQuery("FROM User u WHERE u.username = '" + name + "'", User.class).getSingleResult();
        return user;
    }

    @Override
    @SuppressWarnings("uncheked")
    public List<User> allUsers() {
        Session session = ses.getCurrentSession();
       return session.createQuery("From User").list();
    }

    @Override
    public void add(User user) {
        ses.getCurrentSession().save(user);
    }

    @Override
    public void delete(Long id) {
        Session session = ses.getCurrentSession();
        User user = session.get(User.class, id);
        session.delete(user);

    }

    @Override
    public void edit(User user) {
        Session session = ses.getCurrentSession();
        session.update(user);


    }

    @Override
    public User getById(long id) {
        Session session = ses.getCurrentSession();
        return session.get(User.class, id);
    }



}

