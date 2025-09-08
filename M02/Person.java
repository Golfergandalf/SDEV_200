/* Module 2: Assignment 2
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/3/25
File:   Person.java
*/

public class Person {

    // Variables
    private String name;
    private String address;
    private String phone;
    private String email;

    // Constructor
    public Person(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    // Getter Methods
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }

    // Override
    @Override
    public String toString() {
        return "Person: " + name;
    }
}
