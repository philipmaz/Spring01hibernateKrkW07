package pl.coderslab.spring01hibernatekrkw07.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PersonDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private long streetNumber;
    private String street;
    private String city;

    public long getId() {
        return id;
    }

    public PersonDetails setId(long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public PersonDetails setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PersonDetails setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public long getStreetNumber() {
        return streetNumber;
    }

    public PersonDetails setStreetNumber(long streetNumber) {
        this.streetNumber = streetNumber;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public PersonDetails setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getCity() {
        return city;
    }

    public PersonDetails setCity(String city) {
        this.city = city;
        return this;
    }

    @Override
    public String toString() {
        return "PersonDetails{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", streetNumber=" + streetNumber +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
