package data_proccess;

import db_access.HbFactory;
import entity.Product;
import entity.Supplier;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class SupplierUtil implements EntityUtil<Supplier>{
    @Override
    public void addEntity(Supplier supplier) {
        Session session = null;
        try {
            session = HbFactory.getSession();
            session.getTransaction().begin();
            session.save(supplier);
            session.getTransaction().commit();
            session.close();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public boolean entityExists(Supplier supplier) {
        for (Supplier p : selectAll()) {
            if (p.getName().equals(supplier.getName())) {
                return true;
            }
        }
        return false;
    }

    public List<Supplier> selectAll() {
        List<Supplier> suppliers = null;
        Session session = null;
        try {
            session = HbFactory.getSession();
            session.getTransaction().begin();
            Query query = session.createQuery("from Supplier");
            suppliers = query.list();
            session.getTransaction().commit();
            session.close();

        } catch (RuntimeException e) {
            session.getTransaction().rollback();
        }
        return suppliers;
    }

    public boolean checkByName(String name){
        for (Supplier p : selectAll()) {
            if (p.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public Supplier getByName(String name) {
        for (Supplier p : selectAll()) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }


}
