package anma.hibernate.cfg;

import anma.hibernate.models.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.cfg.Configuration;

//import org.hibernate.cfg.AnnotationConfiguration;

public class CreateDog {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Dog.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            Dog dog = new Dog("barsik", 5, "red");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the dog...");
            session.save(dog);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }



    }


}
