package anma.jdbc.dbs;

import anma.jdbc.dbs.models.Person;
import anma.jdbc.dbs.repositories.PersonRepositoryImpl;
import anma.jdbc.dbs.services.PersonService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

//        System.out.println(new PersonRepositoryImpl().createPerson(new Person(UUID.randomUUID(), "Vasyl", "Vasylenko", 45)));

        new JdbcDBConnector().getAllPersons().forEach(p -> System.out.println(p.getLastName()));
    }
}
