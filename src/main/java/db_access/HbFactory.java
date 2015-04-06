package db_access;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HbFactory {

    private static SessionFactory ourSessionFactory;
    private static ServiceRegistry serviceRegistry;
    private static HbFactory instance;

    private HbFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();

        serviceRegistry = new ServiceRegistryBuilder().
                applySettings(configuration.getProperties()).buildServiceRegistry();
        ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static HbFactory getInstance() {
        if (instance == null) {
            instance = new HbFactory();
        }
        return instance;
    }

    public static Session getSession() {
        return getInstance().ourSessionFactory.openSession();
    }
}
