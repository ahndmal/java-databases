package anma.hibernate.cfg;

import anma.hibernate.models.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateDog {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Dog.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            int dogId = 1;

            session = factory.getCurrentSession();
            session.beginTransaction();

            Dog theDog = session.get(Dog.class, dogId);

            System.out.println("Updating student...");
            theDog.setColor("green");

            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("update Dog set age='7'")
                    .executeUpdate();

            session.getTransaction().commit();


            System.out.println("Done!");


        } finally {
            factory.close();
        }
    }
}
