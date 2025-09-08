/* Module 2: Assignment 2
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/3/25
File:   Employee.java
*/

public class Employee extends Person {

    // Variables
    @SuppressWarnings("unused") // hide compile warnings
    private String office;
    @SuppressWarnings("unused") // hide compile warnings
    private double salary;
    @SuppressWarnings("unused") // hide compile warnings
    private MyDate dateHired;

    // Constructor
    public Employee(String name, String address, String phone, String email, String office, double salary, MyDate dateHired) {
        super(name, address, phone, email);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    // Override
    @Override
    public String toString() {
        return "Employee: " + getName();
    }
}
