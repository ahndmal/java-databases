package anma.jpa;

import anma.hibernate.models.Dog;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JpaDBConnector {

    public EntityManager getEntityManager() {

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("persistence-unit");

        return managerFactory.createEntityManager();
    }

    public boolean createDog(Dog dog) {

        getEntityManager().getTransaction().begin();

        getEntityManager().persist(dog);

        getEntityManager().getTransaction().commit();

        getEntityManager().close();

        return true;

    }

    public List<Dog> getAllCities() {

        getEntityManager().getTransaction().begin();

        List dogs = getEntityManager().createQuery("FROM Dog").getResultList();

        getEntityManager().close();

        return dogs;

    }
}
