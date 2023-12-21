package org.bishop.CombinationPattern;

import java.time.LocalDate;

public class Customer {
    private final String firstName;
    private final  String lastName;

    private final String phoneNumber;

    private final LocalDate dob;

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                '}';
    }

    public Customer(String firstName, String lastName, String phoneNumber, LocalDate dob, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    private final  String email;



}
