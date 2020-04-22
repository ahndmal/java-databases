package anma.jdbc.dbs.repositories;

import anma.jdbc.dbs.models.Person;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface PersonRepository {

    public List<Person> getAllPersons() throws SQLException, ClassNotFoundException;

    public Person getPersonByLastName(String lastName);

    public Person getPersonById(UUID id);

    public boolean createPerson(Person person) throws SQLException, ClassNotFoundException;
}
