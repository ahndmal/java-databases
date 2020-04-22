package anma.hibernate.cfg;

import anma.hibernate.cfg.config.HibernateDBConnector;
import anma.hibernate.cfg.old.crud.CreateDog;
import anma.hibernate.models.Dog;

public class CfgExec {

    public static void main(String[] args) {

//        new HibernateDBConnector().createDog(new Dog("Tuzik", 5, "red"));

//        new HibernateDBConnector().getAllDogs().forEach(dog -> System.out.println(dog));

        System.out.println(new HibernateDBConnector().getDogById(1));;
    }
}
