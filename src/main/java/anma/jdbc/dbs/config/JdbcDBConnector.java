package anma.jdbc.dbs.config;

import anma.jdbc.dbs.config.PropertiesConfig;
import anma.jdbc.dbs.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JdbcDBConnector {

    private final static String GET_PERSONS = "SELECT * FROM persons";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");                                                             //for working in servlets
        return DriverManager.getConnection(
                PropertiesConfig.getProperty(PropertiesConfig.DB_URL),
                PropertiesConfig.getProperty(PropertiesConfig.DB_LOGIN),
                PropertiesConfig.getProperty(PropertiesConfig.DB_PASSWORD));
    }

    public boolean createPerson(Person person) throws SQLException, ClassNotFoundException {

        try(Connection connection = getConnection()) {

        PreparedStatement statement = connection.prepareStatement("INSERT INTO persons VALUES(?,?,?,?)");

        statement.setString(1, person.getId().toString());
        statement.setString(2, person.getFirstName());
        statement.setString(3, person.getLastName());
        statement.setInt(4, person.getAge());

        return statement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            getConnection().close();
        }
        return false;
    }

    public List<Person> getAllPersons() throws SQLException, ClassNotFoundException {

        List<Person> persons = new ArrayList<>();

        try(Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement(GET_PERSONS);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Person person = new Person();

                person.setId(UUID.fromString(resultSet.getString("person_id")));
                person.setAge(resultSet.getInt("age"));
                person.setFirstName(resultSet.getString("first_name"));
                person.setLastName(resultSet.getString("last_name"));
                persons.add(person);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            getConnection().close();
        }
        return persons;
    }

    public List<Person> getPersonsByLastName(String lastName) throws SQLException, ClassNotFoundException {

        List<Person> persons = new ArrayList<>();

        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM persons WHERE last_name LIKE ?");
            System.out.println(statement);
            statement.setString(1, lastName);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Person person = new Person();
                person.setId(UUID.fromString(resultSet.getString("person_id")));
                person.setFirstName(resultSet.getString("first_name"));
                person.setLastName(resultSet.getString("last_name"));
                person.setAge(resultSet.getInt("age"));
                persons.add(person);
            }


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            getConnection().close();
        }

        return persons;
    }





}
