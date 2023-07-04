package com.larsdotpy.personAPI.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="person_info")
public class Person {
    public Person(String personId, String firstName, String lastName, int age, int heightInCm, double weightInKg,
                  String country, boolean married) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.heightInCm = heightInCm;
        this.weightInKg = weightInKg;
        this.country = country;
        this.married = married;
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
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public boolean getMarried() {
        return married;
    }
    public void setMarried(boolean married) {
        this.married = married;
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
    public int getHeightInCm() {
        return heightInCm;
    }
    public void setHeightInCm(int heightInCm) {
        this.heightInCm = heightInCm;
    }
    public double getWeightInKg() {
        return weightInKg;
    }
    public void setWeightInKg(double weightInKg) {
        this.weightInKg = weightInKg;
    }

    @Id
    private String personId;
    private String firstName;
    private String lastName;
    private int age;
    private int heightInCm;
    private double weightInKg;
    private String country;
    private boolean married;
}
