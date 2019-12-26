package anma.hibernate.cfg.crud;

import anma.hibernate.cfg.HibernateCfgUtil;
import anma.hibernate.models.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.cfg.Configuration;

//import org.hibernate.cfg.AnnotationConfiguration;

public class CreateDog {

    public static Dog createDog(String name, int age, String color) {

        SessionFactory factory = HibernateCfgUtil.getSessionFactory();

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
