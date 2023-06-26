package com.larsdotpy.personAPI.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="person_info")
public class Person {
    public Person(String personId, String firstName, String Address, String PhoneNumber) {
        this.personId = personId;
        this.firstName = firstName;
        this.Address = Address;
        this.PhoneNumber = PhoneNumber;
    }

    public Person() {
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }

    @Id
    private String personId;
    private String firstName;
    private String Address;
    private String PhoneNumber;
}
