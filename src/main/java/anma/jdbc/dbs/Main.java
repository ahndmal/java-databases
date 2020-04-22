package anma.jdbc.dbs;

import anma.jdbc.dbs.config.JdbcDBConnector;
import anma.jdbc.dbs.models.Person;

import java.sql.SQLException;
import java.util.UUID;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

//        System.out.println(new PersonRepositoryImpl().createPerson(new Person(UUID.randomUUID(), "Vasyl", "Vasylenko", 45)));

        Person person = new Person();
        person.setFirstName("New Name");
        person.setLastName("New Name");
        person.setAge(50);

        System.out.println(new JdbcDBConnector().updatePerson(person , "551581d1-6576-47ed-bcb9-906e4434774e"));

        new JdbcDBConnector().getPersonsByLastName("Vasylenko").forEach(p -> System.out.println(p.getLastName()));
    }
}
