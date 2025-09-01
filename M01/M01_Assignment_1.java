/* Module 1: Assignment 1
Name:   Gabby Willard
Class:  SDEV 200
Date:   8/25/25
File:   M01_Assignment_1.java
*/

public class M01_Assignment_1 {

    // Display the table
    public static void main (String args[]) {

        // Table Header
        System.out.printf("%-10s%-10s    %-10s%-10s\n", "Feet", "Meters", "Meters", "Feet");
        System.out.println("--------------------------------------------------");

        // Print rows
        for (int i = 1, j = 20; i <= 10 && j <= 65; i++, j += 5) {
            double feet = i;
            double meters = j;
            double metersFromFeet = footToMeter(feet);
            double feetFromMeters = meterToFoot(meters);

            System.out.printf("%-10.1f%-10.3f    %-10.1f%-10.3f\n", feet, metersFromFeet, meters, feetFromMeters);
        }
    }

    /** Convert from feet to meters */
    public static double footToMeter (double foot) {
        return 0.305 * foot;
    }
    /** Convert from meters to feet */
    public static double meterToFoot (double meter) {
        return 3.279 * meter;
    }
}
