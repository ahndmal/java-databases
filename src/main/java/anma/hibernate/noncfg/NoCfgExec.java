package anma.hibernate.noncfg;

import anma.hibernate.models.Dog;
import org.hibernate.Session;

import java.util.List;

public class NoCfgExec {

    public static void main(String[] args) {

        Session session = HibernateUtilNoCfg.getSessionFactory().openSession();
        session.beginTransaction();

        String SQL = "select * From dogs";

        List<Dog> dogs = session.createNativeQuery(SQL).getResultList();

        System.out.println(dogs);

        session.getTransaction().commit();
        session.close();

        HibernateUtilNoCfg.shutdown();
    }
}
