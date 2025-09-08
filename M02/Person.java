/* Module 2: Assignment 2
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/3/25
File:   Person.java
*/

public class Person {

    // Variables
    private String name;
    @SuppressWarnings("unused") // hide compile warnings
    private String address;
    @SuppressWarnings("unused") // hide compile warnings
    private String phone;
    @SuppressWarnings("unused") // hide compile warnings
    private String email;

    // Constructor
    public Person(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    // Get Method
    public String getName() {
        return name;
    }

    // Override
    @Override
    public String toString() {
        return "Person: " + name;
    }
}
