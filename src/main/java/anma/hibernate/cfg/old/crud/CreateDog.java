package anma.hibernate.cfg.old.crud;

import anma.hibernate.cfg.old.HibernateCfgUtilOld;
import anma.hibernate.models.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

//import org.hibernate.cfg.AnnotationConfiguration;

public class CreateDog {

    public static Dog createDog(String name, int age, String color) {

        SessionFactory factory = HibernateCfgUtilOld.getSessionFactory();

        Dog dog;

        Session session = factory.getCurrentSession();

        try {

            dog = new Dog(name, age, color);

            // start a transaction
            session.beginTransaction();

            // save the student object
            session.save(dog);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Dog created! ");
            System.out.println(dog.toString());


        } finally {
            factory.close();
        }

        return dog;

    }


}
