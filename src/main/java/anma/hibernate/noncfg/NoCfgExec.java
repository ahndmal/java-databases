package anma.hibernate.noncfg;

import anma.hibernate.models.Dog;
import anma.hibernate.noncfg.config.HibernateUtilNoCfgConnector;
import org.hibernate.Session;

import java.util.List;

public class NoCfgExec {

    public static void main(String[] args) {

        new HibernateUtilNoCfgConnector().getAllDogs().forEach(dog -> System.out.println(dog));

        HibernateUtilNoCfgConnector.shutdown();
    }
}
