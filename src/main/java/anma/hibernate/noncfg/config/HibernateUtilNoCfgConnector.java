package anma.hibernate.noncfg.config;

import anma.PropertiesConfig;
import anma.hibernate.models.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HibernateUtilNoCfgConnector {

    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {

            try {
                // Create registry builder
                StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

                // Hibernate settings equivalent to old-hibernate.cfg.xml's properties
                Map<String, String> settings = new HashMap<>();

                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/dogs");
                settings.put(Environment.USER, "postgres");
                settings.put(Environment.PASS, "porkie");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL10Dialect");

                // Apply settings
                registryBuilder.applySettings(settings);

                // Create registry
                registry = registryBuilder.build();

                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);

                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();

                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();

            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    public List<Dog> getAllDogs() {

        Session session = getSessionFactory().openSession();

        session.getTransaction().begin();

        List<Dog> dogs = session.createQuery("FROM Dog", Dog.class).list();

        session.close();

        return dogs;
    }

    public Dog getDogById(Integer id) {

        Session session = getSessionFactory().openSession();

        session.getTransaction().begin();

        Dog dog = session.get(Dog.class, id);

        session.close();

        return dog;
    }

    public Dog createDog(Dog dog) {

        Session session = getSessionFactory().openSession();

        session.getTransaction().begin();

        session.save(dog);

        session.getTransaction().commit();

        session.close();

        return dog;

    }


    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
