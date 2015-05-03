package shop.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.dao.ProductDaoImpl;
import shop.entity.Product;
import java.util.List;

@Service("productService")
@Transactional
public class ProductService {
    @Autowired
    private ProductDaoImpl productDao;

    public void addEntity(Product product) {
        productDao.addEntity(product);
    }

    public boolean entityExists(Product product) {
        return productDao.entityExists(product);
    }

    public List<Product> selectAll() {
        return productDao.selectAll();
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
