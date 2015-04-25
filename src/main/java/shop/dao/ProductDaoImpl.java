package shop.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.entity.Product;
import shop.entity.User;

import java.util.List;

@Repository
public class ProductDaoImpl implements EntityDao<Product> {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void addEntity(Product product) {
        sessionFactory.getCurrentSession().saveOrUpdate(product);
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

    @Override
    public List<Product> selectAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
        return (List<Product>) criteria.list();
    }
}
