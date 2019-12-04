package anma.jdbc.dbs.services;

import anma.jdbc.dbs.models.Person;

import java.sql.SQLException;
import java.sql.Statement;

public class PersonService {

    public static String createPerson(Statement statement, String table, Person person) {

        String sql = "insert into " + table
                + " values ("
                + person.getId() + ","
                + "\'" +
                person.getFirstName()
                + "\'" +","
                + "\'"
                + person.getLastName()
                + "\'"
                +","
                + person.getAge()
                + ")";

        try {

            statement.execute(sql);

            return sql;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(sql);
            return "false";

        }

    }
}
