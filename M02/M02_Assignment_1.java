/* Module 2: Assignment 1
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/3/25
File:   M02_Assignment_1.java
*/

public class M02_Assignment_1 {
    public static void main(String args[]) {

        // Variables
        // Current date
        MyDate date1 = new MyDate();
        // Specified elapsed time
        MyDate date2 = new MyDate(34355555133101L);

        // Print these
        System.out.println("Date 1: " + date1.getYear() + "-" + (date1.getMonth()+1) + "-" + date1.getDay());
        System.out.println("Date 2: " + date2.getYear() + "-" + (date2.getMonth()+1) + "-" + date2.getDay());
    }
}
