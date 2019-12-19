package anma.hibernate;

import anma.hibernate.models.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.cfg.Configuration;

//import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateMain {

//    private static final SessionFactory sessionFactory = buildSessionFactory();
//
//    private static SessionFactory buildSessionFactory() {
//        try {
//            // Create the SessionFactory from hibernate.cfg.xml
//            return new AnnotationConfiguration().configure().buildSessionFactory();
//
//        }
//        catch (Throwable ex) {
//            // Make sure you log the exception, as it might be swallowed
//            System.err.println("Initial SessionFactory creation failed." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }

    public static void main(String[] args) {

        MetadataSources sources = new MetadataSources();

        sources.addAnnotatedClass(Dog.class);

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Dog.class)
                .buildSessionFactory();

//        ServiceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
//
//        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Session session = factory.getCurrentSession();

        try {

            Dog dog = new Dog();
            dog.setId(1);
            dog.setName("Sharik");
            dog.setAge(5);
            dog.setColor("red");

            session.beginTransaction();

            session.save(dog);

            session.getTransaction().commit();

            System.out.println("Done!");


        } finally {
            session.close();
        }







    }


}
