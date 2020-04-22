package anma.jdbc.dbs;

import anma.jdbc.dbs.config.JdbcDBConnector;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

//        System.out.println(new PersonRepositoryImpl().createPerson(new Person(UUID.randomUUID(), "Vasyl", "Vasylenko", 45)));

        new JdbcDBConnector().getPersonsByLastName("Vasylenko").forEach(p -> System.out.println(p.getLastName()));
    }
}
