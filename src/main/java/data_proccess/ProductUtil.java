package data_proccess;

import db_access.HbFactory;
import entity.Product;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;


public class ProductUtil implements EntityUtil<Product>{

    @Override
    public void addEntity(Product product) {
        Session session = null;
        try {
            session = HbFactory.getSession();
            session.getTransaction().begin();
            session.save(product);
            session.getTransaction().commit();
            session.close();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public boolean entityExists(Product product) {
        for (Product p : selectAll()) {
            if (p.getName().equals(product.getName())) {
                return true;
            }
        }
        return false;
    }

    public List<Product> selectAll() {
        List<Product> products = null;
        Session session = null;
        try {
            session = HbFactory.getSession();
            session.getTransaction().begin();
            Query query = session.createQuery("from Product");
            products = query.list();
            session.getTransaction().commit();
            session.close();

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
        }
        return products;
    }

    public Product getById(Integer id) {
        for (Product p : selectAll()) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

}
