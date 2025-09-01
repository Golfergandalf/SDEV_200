/* Module 1: Assignment 3
Name:   Gabby Willard
Class:  SDEV 200
Date:   8/25/25
File:   M01_Assignment_3.java
*/

/* 8.29 (Identical Arrays)
The two-dimensional arrays m1 and m2 are identical if they have the same contents.
Write a method that returns true if m1 and m2 are identical, using the following header:
    public static boolean equals(int[][] m1, int[][] m2)

Write a test program that prompts the user to enter two 3×3 arrays of integers and displays whether the two are identical.
*/

import java.util.Scanner;
public class M01_Assignment_3 {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        int[][] array1 = new int[3][3];
        int[][] array2 = new int[3][3];

        // Get input for first array
        System.out.println("Enter 9 integers for the first 3x3 array:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array1[i][j] = input.nextInt();
            }
        }

        // Get input for second array
        System.out.println("Enter 9 integers for the second 3x3 array:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array2[i][j] = input.nextInt();
            }
        }

        // Check if arrays are identical
        if (equals(array1, array2)) {
            System.out.println("The two arrays are identical.");
        } else {
            System.out.println("The two arrays are not identical.");
        }

        input.close();
    }

    public static boolean equals(int[][] m1, int[][] m2) {
        // Check if the dimensions are the same
        if (m1.length != m2.length || m1[0].length != m2[0].length) {
            return false;
        }

        // Compare each element
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                if (m1[i][j] != m2[i][j]) {
                    return false;
                }
            }
        }
        return true; // All elements match
    }
}