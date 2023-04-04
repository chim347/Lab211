package data;

import java.time.LocalDate;

public class Student {

    protected String id;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;

    public Student() {
    }

    public Student(String id, String firstName, String lastName, String gender, LocalDate dateOfBirth, String email, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void displayStudent() {
        System.out.println("|++ Student ID ++|++First Name++|++Last Name++|++ Gender ++|++ Date Of Birth ++|++++++++++ Email ++++++++++|+++ Phone Number +++|");
        System.out.printf("|%-16s|%-14s|%-13s|%-12s|%19s|%-27s|%20s|\n", id, firstName, lastName, gender, dateOfBirth, email, phoneNumber);

    }

}
