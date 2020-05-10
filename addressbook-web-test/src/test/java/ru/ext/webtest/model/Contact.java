package ru.ext.webtest.model;

public class Contact {
    private final String firstname;
    private final String lastname;
    private final String address;
    private final String homePhoneNumber;
    private final String email1;
    private final String email2;

    public Contact(String firstname, String lastname, String address, String homePhoneNumber, String email1, String email2) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.homePhoneNumber = homePhoneNumber;
        this.email1 = email1;
        this.email2 = email2;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public String getEmail1() {
        return email1;
    }

    public String getEmail2() {
        return email2;
    }
}
