package pl.coderslab.spring01hibernatekrkw07.model;

import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private String gender;
    private String country;
    private String notes;
    private boolean mailingList;
    private List programmingSkills;
    private List Hobbies;

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", country='" + country + '\'' +
                ", notes='" + notes + '\'' +
                ", mailingList=" + mailingList +
                ", programmingSkills=" + programmingSkills +
                ", Hobbies=" + Hobbies +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Student setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Student setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public Student setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public boolean isMailingList() {
        return mailingList;
    }

    public Student setMailingList(boolean mailingList) {
        this.mailingList = mailingList;
        return this;
    }

    public List getProgrammingSkills() {
        return programmingSkills;
    }

    public Student setProgrammingSkills(List programmingSkills) {
        this.programmingSkills = programmingSkills;
        return this;
    }

    public List getHobbies() {
        return Hobbies;
    }

    public Student setHobbies(List hobbies) {
        Hobbies = hobbies;
        return this;
    }
}
