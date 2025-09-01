/* Module 1: Assignment 2
Name:   Gabby Willard
Class:  SDEV 200
Date:   8/25/25
File:   M01_Assignment_2.java
*/

/* 6.31 (Financial: credit card and number validation)
Credit card numbers follow certain patterns. A credit card number must have between 13 and 16 digits. It must start with
    * 4 for Visa cards
    * 5 for Master cards
    * 37 for American Express cards
    * 6 for Discover cards

In 1954, Hans Luhn of IBM proposed an algorithm for validating credit card numbers. The algorithm is useful to determine whether a card number is entered correctly, or whether a credit card is scanned correctly by a scanner. Credit card numbers are generated following this validity check, commonly known as the Luhn check or the Mod 10 check, which can be described as follows (for illustration, consider the card number 4388576018402626):
    1. Double every second digit from right to left. If doubling of a digit results in a two-digit number, add up the two digits to get a single-digit number.
    2. Now add all single-digit numbers from Step 1.
    3. Add all digits in the odd places from right to left in the card number.
    4. Sum the results from Step 2 and Step 3.
    5. If the result from Step 4 is divisible by 10, the card number is valid; otherwise, it is invalid. For example, the number 4388576018402626 is invalid, but the number 4388576018410707 is valid.

Write a program that prompts the user to enter a credit card number as a long integer.
Display whether the number is valid or invalid. Design your program to use the following methods:
    * Return true if the card number is valid
        public static boolean isValid(long number)
    * Get the result from Step 2
        public static int sumOfDoubleEvenPlace(long number)
    * Return this number if it is a single digit, otherwise, return the sum of the two digits
        public static int getDigit(int number)
    * Return sum of odd-place digits in number
        public static int sumOfOddPlace(long number)
    * Return true if the number d is a prefix for number
        public static boolean prefixMatched(long number, int d)
    * Return the number of digits in d
        public static int getSize(long d)
    * Return the first k number of digits from number. If the number of digits in number is less than k, return number.
        public static long getPrefix(long number, int k)
*/

import java.util.Scanner;
@SuppressWarnings("resource")
public class M01_Assignment_2 {
    
    // Main Method
    public static void main (String args[]) {
        Scanner input = new Scanner(System.in);
        
        // Ask for the credit card number (13-16 numbers)
        System.out.println("Enter a credit card number that is 13-16 numbers long: ");
        long number = input.nextLong();
        
        // Check if the input is valid
        if (isValid(number)) {
            System.out.println(number + " is valid!");
        } else {
            System.out.println(number + " is not valid!");
        }
    }
    
    // Methods
/* Return true if the card number is valid */
    public static boolean isValid (long number) {
        return false;
    }

/* Get the result from Step 2 */
    public static int sumOfDoubleEvenPlace (long number) {
        return 0;
    }

    /* Return this number if it is a single digit, otherwise, return the sum of the two digits */
    public static int getDigit (int number) {
        if (number < 10) {
            // if number is under 10, return number
            return number;
        } else {
            // if number is greater than 10, return the sum of the two digits
            return (number / 10) + (number % 10);
        }
    }

/* Return sum of odd-place digits in number */
    public static int sumOfOddPlace (long number) {
        return 0;
    }

    /* Return true if the number d is a prefix for number */
    public static boolean prefixMatched (long number, int d) {
        return getPrefix(number, getSize(d)) == d;
    }

    /* Return the number of digits in d */
    public static int getSize (long d) {
        return String.valueOf(d).length();
    }

    /* Return the first k number of digits from number. If the number of digits in number is less than k, return number. */
    public static long getPrefix (long number, int k) {
        String numString = String.valueOf(number);
        if (numString.length() <= k) {
            // When less than k, return number
            return number;
        } else {
            // When greater than k
            return Long.parseLong(numString.substring(0, k));
        }
    }
}
