package anma.jdbc.dbs.repositories;

import anma.jdbc.dbs.config.JdbcDBConnector;
import anma.jdbc.dbs.models.Person;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class PersonRepositoryImpl implements PersonRepository {

    @Override
    public List<Person> getAllPersons() throws SQLException, ClassNotFoundException {
        return new JdbcDBConnector().getAllPersons();
    }

    @Override
    public Person getPersonByLastName(String lastName) {
        return null;
    }

    @Override
    public Person getPersonById(UUID id) {
        return null;
    }

    @Override
    public boolean createPerson(Person person) throws SQLException, ClassNotFoundException {
        return new JdbcDBConnector().createPerson(person);
    }
}
