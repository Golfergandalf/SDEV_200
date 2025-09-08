/* Module 2: Assignment 2
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/3/25
File:   Student.java
*/

public class Student extends Person {
    public static final int FRESHMAN = 1;
    public static final int SOPHOMORE = 2;
    public static final int JUNIOR = 3;
    public static final int SENIOR = 4;

    private int status;

    public Student(String name, String address, String phone, String email, int status) {
        super(name, address, phone, email);
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student: " + getName();
    }
}
