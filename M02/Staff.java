/* Module 2: Assignment 2
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/3/25
File:   Staff.java
*/

public class Staff extends Employee {

    // Variables
    private String title;

    // Constructor
    public Staff(String name, String address, String phone, String email, String office, double salary, MyDate dateHired, String title) {
        super(name, address, phone, email, office, salary, dateHired);
        this.title = title;
    }

    // Getter Methods
    public String getTitle() {
        return title;
    }

    // Override
    @Override
    public String toString() {
        return "Staff: " + getName();
    }
}
