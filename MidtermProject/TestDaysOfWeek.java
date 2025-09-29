/* Module 4: Midterm Project
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/8/25
File:   TestDaysOfWeek.java
*/

import daysAndDates.DaysOfWeek; // Fixed typo "Inport" to "import"
public class TestDaysOfWeek {
    public static void main(String[] args) {
        System.out.println("Days Of Week: ");
        for (int i = 1; i <= 7; i++) { // Fixed loop to start at 1 and go to 7
            System.out.println("Number: " + i + "\tDay Of Week: " + DaysOfWeek.DayOfWeekStr(i)); // Added missing semicolon at end of println statement
        }
    }
}
