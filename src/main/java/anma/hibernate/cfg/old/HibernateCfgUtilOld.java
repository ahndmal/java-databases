package anma.hibernate.cfg.old;

import anma.hibernate.models.Dog;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateCfgUtilOld {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            try {

                sessionFactory = new Configuration()
                        .configure("old-hibernate.cfg.xml")
                        .addAnnotatedClass(Dog.class)
                        .buildSessionFactory();

            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        return sessionFactory;
    }
}
