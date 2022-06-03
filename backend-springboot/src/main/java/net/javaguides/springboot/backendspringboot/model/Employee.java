package net.javaguides.springboot.backendspringboot.model;

import javax.persistence.*;


@Entity // Specifies class as a JPA entity
@Table(name = "employees") // Generates database along with the attribute that specifies the name of the database
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")       // Entity vales or attributes represented in the database
    private String firstName;         // name or variable for testing or production

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public Employee() {
        super();
    }  // No argument constructor

    public Employee(String firstName, String lastName, String email) {
        super(); // the purpose of the constructor it to set and get values
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }


    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
}
