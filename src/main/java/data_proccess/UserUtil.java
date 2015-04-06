package data_proccess;

import db_access.HbFactory;
import entity.Supplier;
import entity.User;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class UserUtil implements EntityUtil<User>{

    @Override
    public void addEntity(User user) {
        Session session = null;
        try {
            session = HbFactory.getSession();
            session.getTransaction().begin();
            session.save(user);
            session.getTransaction().commit();
            session.close();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
        }
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
        List<User> users = null;
        Session session = null;
        try {
            session = HbFactory.getSession();
            session.getTransaction().begin();
            Query query = session.createQuery("from User");
            users = query.list();
            session.getTransaction().commit();
            session.close();

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
        }
        return users;
    }

    public User getByLoginAndPassword(String login, String password) {
        for (User u : selectAll()) {
            if (u.getLogin().equals(login) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

}