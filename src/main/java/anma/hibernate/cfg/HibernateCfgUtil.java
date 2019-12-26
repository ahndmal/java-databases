package anma.hibernate.cfg;

import anma.hibernate.models.Dog;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateCfgUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            try {

                sessionFactory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Dog.class)
                        .buildSessionFactory();

            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        return sessionFactory;
    }
}
