package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.dao.UserDaoImpl;
import shop.entity.User;
import java.util.List;

@Service("userService")
@Transactional
public class UserService {
    @Autowired
    private UserDaoImpl userDao;

    public User getByLoginAndPassword(String login, String password) {
        for (User u : selectAll()) {
            if (u.getLogin().equals(login) & u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    public void addEntity(User user) {
       userDao.addEntity(user);
    }

    public boolean entityExists(User user) {
        return userDao.entityExists(user);
    }

    public List<User> selectAll() {
        return userDao.selectAll();
    }
}
