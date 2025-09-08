/* Module 2: Assignment 3
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/3/25
File:   M02_Assignment_3.java
*/

import java.util.Scanner;

public class M02_Assignment_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a binary number: ");
        String binaryString = input.nextLine();

        try {
            int decimal = bin2Dec(binaryString);
            System.out.println("Decimal equivalent: " + decimal);
        } catch (NumberFormatException ex) {
            System.out.println("Not a binary number");
        }
    }

    // Method to convert binary string to decimal
    public static int bin2Dec(String binaryString) throws NumberFormatException {
        // Check if the string contains only 0 or 1
        for (int i = 0; i < binaryString.length(); i++) {
            char c = binaryString.charAt(i);
            if (c != '0' && c != '1') {
                throw new NumberFormatException("Not a binary number");
            }
        }

        // Convert to decimal
        int decimal = 0;
        int length = binaryString.length();
        for (int i = 0; i < length; i++) {
            // start from rightmost bit
            char c = binaryString.charAt(length - 1 - i);
            if (c == '1') {
                decimal += Math.pow(2, i);
            }
        }
        return decimal;
    }
}
