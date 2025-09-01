/* Module 1: Assignment 3
Name:   Gabby Willard
Class:  SDEV 200
Date:   8/25/25
File:   M01_Assignment_3.java
*/

import java.util.Scanner;
public class M01_Assignment_3 {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        int[][] m1 = new int[3][3];
        int[][] m2 = new int[3][3];

        // Get input for first array
        System.out.print("Enter m1 (a 3 by 3 matrix) row by row: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m1[i][j] = input.nextInt();
            }
        }

        // Get input for second array
        System.out.print("Enter m2 (a 3 by 3 matrix) row by row: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m2[i][j] = input.nextInt();
            }
        }

        // Check if arrays are identical
        if (equals(m1, m2)) {
            System.out.println("The two arrays are identical");
        } else {
            System.out.println("The two arrays are not identical");
        }

        input.close();
    }

    public static boolean equals(int[][] m1, int[][] m2) {

        // Check if the dimensions are the same
        if (m1.length != m2.length || m1[0].length != m2[0].length) {
            // The lengths aren't the same
            return false;
        }

        // Compare each element
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                if (m1[i][j] != m2[i][j]) {
                    // If they don't match
                    return false;
                }
            }
        }
        // If they do match
        return true;
    }
}
