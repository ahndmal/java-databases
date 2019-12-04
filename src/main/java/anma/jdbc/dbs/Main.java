package anma.jdbc.dbs;

import anma.jdbc.dbs.models.Person;
import anma.jdbc.dbs.services.PersonService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Statement statement = Connector.getStatement("jdbc:postgresql://localhost:5433/persons", "andriim", "Porkie");

        Person ignat = new Person(2, "Ignat", "Ignatenko", 36);

        PersonService.createPerson(statement, "public.persons", ignat);

        ResultSet resultSet = Connector.getResults(statement, "public.persons");

//            while (resultSet.next()) {
//                System.out.printf("%-30.30s  %-30.30s%n", resultSet.getString("model"), resultSet.getString("price"));
//            }

        while (resultSet.next()) {
            System.out.print(resultSet.getString("person_id") + " | ");
            System.out.print(resultSet.getString("first_name") + " | ");
            System.out.print(resultSet.getString("last_name") + " | ");
            System.out.print(resultSet.getString("age"));
        }


    }
}
