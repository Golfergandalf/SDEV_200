/* Module 1: Assignment 2
Name:   Gabby Willard
Class:  SDEV 200
Date:   8/25/25
File:   M01_Assignment_2.java
*/

import java.util.Scanner;
public class M01_Assignment_2 {
    
    // Main Method
    public static void main (String args[]) {
        Scanner input = new Scanner(System.in);
        
        // Ask for the credit card number (13-16 numbers)
        System.out.println("Enter a credit card number that is 13-16 numbers long: ");
        long number = input.nextLong();
        
        // Check the credit card number
        if (isValid(number)) {
            System.out.println("The input: " + number + " is a valid credit card number!");
        } else {
            System.out.println("The input: " + number + " is not a valid credit card number!");
        }
    }
    
    // More Methods

    /* Return this number if it is a single digit, otherwise, return the sum of the two digits */
    public static int getDigit (int number) {
        if (number < 10) {
            // If number is under 10, return number as is
            return number;
        } else {
            // Else number is over 10, return the sum of the two digits
            return (number / 10) + (number % 10);
        }
    }

    /* Return the number of digits in d */
    public static int getSize (long d) {
        // Converts the number to a string & returns its length
        return String.valueOf(d).length();
    }

    /* Return the first k number of digits from number. If the number of digits in number is less than k, return number. */
    public static long getPrefix (long number, int k) {
        String numberString = String.valueOf(number);

        if (numberString.length() <= k) {
            // If number is shorter than k digits, return the number as is
            return number;
        } else {
            // Else number is greater than k digits, take only first k digits
            return Long.parseLong(numberString.substring(0, k));
        }
    }

    /* Return true if the number d is a prefix for number */
    public static boolean prefixMatched (long number, int d) {
        if (getPrefix(number, getSize(d)) == d) {
            // the prefix does match
            return true;
        } else {
            // the prefix does not match
            return false;
        }
    }

    /* Get the result from Step 2 */
    public static int sumOfDoubleEvenPlace (long number) {
        
        // Reverse the number string to make it easier to access the even places
        String numberString = new StringBuilder(String.valueOf(number)).reverse().toString();
        int sum = 0;

        // Start at the 2nd digit from the right and advance places by 2
        for (int i = 1; i < numberString.length(); i += 2) {
            int digit = Character.getNumericValue(numberString.charAt(i));
            
            // Double it & adjust if it becomes 2 digits
            sum += getDigit(digit * 2);
        }
        return sum;
    }

    /* Return sum of odd-place digits in number */
    public static int sumOfOddPlace (long number) {

        // Reverse the number string to make it easier to access the odd places
        String numberString = new StringBuilder(String.valueOf(number)).reverse().toString();
        int sum = 0;

        // Start at the first digit from the right
        for (int i = 0; i < numberString.length(); i += 2) {
            int digit = Character.getNumericValue(numberString.charAt(i));
            
            // Add every digit in the odd places
            sum += digit;
        }
        return sum;
    }

    /* Return true if the card number is valid */
    public static boolean isValid (long number) {
        
        // Is the number length not between 13 and 16 digits?
        int sizeOfNumber = getSize(number);
        if (sizeOfNumber < 13 || sizeOfNumber > 16) {
            return false;
        }

        // Is the prefix not 4, 5, 37, or 6?
        if (!(prefixMatched(number, 4) || prefixMatched(number, 5) || prefixMatched(number, 37) || prefixMatched(number, 6))) {
            return false;
        }

        // Does it pass the Luhn check?
        int sum = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
        if (sum % 10 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
