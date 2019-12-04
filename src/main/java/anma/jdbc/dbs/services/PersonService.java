package anma.jdbc.dbs.services;

import anma.jdbc.dbs.models.Person;

import java.sql.SQLException;
import java.sql.Statement;

public class PersonService {

    public static boolean createPerson(Statement statement, String table, Person person) {

        try {
            statement.execute("insert into " + table
                    + " values ("
                    + person.getId() + ","
                    + person.getFirstName() +","
                    + person.getLastName() +","
                    + person.getAge()
                    + ")");

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}
