package web.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.Role;
import web.model.User;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService, UserService {

    private final UserDao userDao;

    private final PasswordEncoder crypt;

    // «Пользователь» – это просто Object. В большинстве случаев он может быть
    //  приведен к классу UserDetails.
    // Для создания UserDetails используется интерфейс UserDetailsService, с единственным методом:

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDao.getUserByName(s);
    }


    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }


    @Override
    public List<User> allUsers(){
        return userDao.findAll();
    }


    @Override
    public void add(User user){
        user.setRoles(Collections.singleton(new Role("ROLE_USER")));
        user.setPassword(crypt.encode(user.getPassword()));
        userDao.save(user);


    }


    @Override
    public void delete(Long id){
        userDao.deleteById(id);
    }


    @Override
    public void edit(Long id, String username, String password){
        userDao.edit(id, username, password);
    }


    @Override
    public User getById(long id){
        return userDao.getById(id);
    }


}
