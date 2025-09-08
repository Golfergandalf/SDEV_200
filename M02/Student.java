/* Module 2: Assignment 2
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/3/25
File:   Student.java
*/

public class Student extends Person {

    // Variables
    public static final int FRESHMAN = 1;
    public static final int SOPHOMORE = 2;
    public static final int JUNIOR = 3;
    public static final int SENIOR = 4;

    @SuppressWarnings("unused") // hide compile warnings
    private int status;

    // Constructor
    public Student(String name, String address, String phone, String email, int status) {
        super(name, address, phone, email);
        this.status = status;
    }

    // Override
    @Override
    public String toString() {
        return "Student: " + getName();
    }
}
