package anma.hibernate.cfg.old.crud;

import anma.hibernate.models.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDog {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("old-hibernate.cfg.xml")
                .addAnnotatedClass(Dog.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            int dogId = 1;

            // now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve dog based on the id: primary key
            System.out.println("\nGetting dog with id: " + dogId);

            Dog myDog = session.get(Dog.class, dogId);

            // delete the dog
            // System.out.println("Deleting dog: " + myDog);
            // session.delete(myStudent);

            // delete dog id=2
            System.out.println("Deleting dog id=2");

            session.createQuery("delete from Dog where id=2").executeUpdate();

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
