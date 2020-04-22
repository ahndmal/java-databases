package anma.hibernate.cfg.config;

import anma.hibernate.models.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HibernateDBConnector {

    private Metadata metadata;

    public SessionFactory getSessionFactory() {

        try {

            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

            metadata = new MetadataSources(registry).getMetadataBuilder().build();

        } catch (Throwable e) {
            e.printStackTrace();
        }

        return metadata.getSessionFactoryBuilder().build();
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
}
