/* Module 2: Assignment 1
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/3/25
File:   MyDate.java
*/

import java.util.GregorianCalendar;
import java.util.Calendar;

class MyDate {
    
    // Variables
    private int year;
    private int month;
    private int day;

    // Constructors
    // No-arg constructor: current date
    public MyDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH);
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
    }
    // Constructor with elapsed time
    public MyDate(long elapsedTime) {
        setDate(elapsedTime);
    }
    // Constructor with specified year, month, day
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // Getters
    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }

    // Set date using elapsed time
    public void setDate(long elapsedTime) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(elapsedTime);
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH);
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
    }
}
