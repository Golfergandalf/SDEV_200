/* Module 2: Assignment 2
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/3/25
File:   Faculty.java
*/
//@SuppressWarnings("unused") // hide compile warnings

public class Faculty extends Employee {

    // Variables
    private String officeHours;
    private String rank;

    // Constructor
    public Faculty(String name, String address, String phone, String email, String office, double salary, MyDate dateHired, String officeHours, String rank) {
        super(name, address, phone, email, office, salary, dateHired);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    // Getter Methods
    public String getOfficeHours() {
        return officeHours;
    }
    public String getRank() {
        return rank;
    }

    // Override
    @Override
    public String toString() {
        return "Faculty: " + getName();
    }
}
