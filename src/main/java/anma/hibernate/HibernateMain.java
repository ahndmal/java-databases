package anma.hibernate;

import anma.hibernate.models.Person;
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

        sources.addAnnotatedClass(Person.class);

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();

//        ServiceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
//
//        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Session session = factory.getCurrentSession();

        try {

            Person person = new Person();
            person.setFirstName("Vasyl");
            person.setLastName("Vasylenko");

            session.beginTransaction();

            session.save(person);

            session.getTransaction().commit();


        } finally {
            session.close();
        }







    }


}
