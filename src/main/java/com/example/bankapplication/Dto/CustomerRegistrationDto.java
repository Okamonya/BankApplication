package com.example.bankapplication.Dto;

public class CustomerRegistrationDto {
    private String firstName;
    private String lastName;
    private String kra;
    private String ssn;
    private String password;

    public CustomerRegistrationDto(){

    }

    public CustomerRegistrationDto(String firstName, String lastName, String kra, String ssn, String password) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.kra = kra;
        this.ssn = ssn;
        this.password = password;
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
    public String getKra() {

        return kra;
    }
    public void setKra(String kra) {

        this.kra = kra;
    }
    public String getSsn() {
        return ssn;
    }
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    public String getPassword() {

        return password;
    }
    public void setPassword(String password) {

        this.password = password;
    }
}
