package anma.hibernate.models;

import javax.persistence.*;

@Entity
@Table(name="dogs")
public class Dog {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="dog_id")
    private Integer id;

//    @Column(name="dog_name")
    private String name;

//    @Column(name = "dog_age")
    private int age;

//    @Column(name = "dog_color")
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public Dog() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
