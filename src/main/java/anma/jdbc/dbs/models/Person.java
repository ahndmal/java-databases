package anma.jdbc.dbs.models;

public class Person {

    private long id;
    private String firstName;
    private String lastName;
    private int age;

    public Person(long id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person = " + "{Id : "
                + String.valueOf(this.getId())
                + ", First Name : " + this.getFirstName()
                + ", Last Name : " + this.getLastName()
                + ", Age : " + this.getAge()
                + "}";
    }
}
