package shop.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.entity.User;

import java.util.List;


@Repository
public class UserDaoImpl implements EntityDao<User> {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addEntity(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public boolean entityExists(User user) {
        for (User u : selectAll()) {
            if (u.getLogin().equals(user.getLogin())
                    && u.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public List<User> selectAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        return (List<User>) criteria.list();
    }
}
