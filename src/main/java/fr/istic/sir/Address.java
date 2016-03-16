package fr.istic.sir;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Address {

    private String street;
    private String city;
    private String postCode;
    private String country;

    public Address() {
        super();
    }

    public Address(String street, String country, String postCode, String city) {
        this.street = street;
        this.country = country;
        this.postCode = postCode;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}