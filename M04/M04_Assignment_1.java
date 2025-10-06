/* Module 4: Assignment 1
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/8/25
File:   M04_Assignment_1.java
*/

/* 20.11 (Match grouping symbols)
A Java program contains various pairs of grouping symbols, such as:
    • Parentheses: ( and )
    • Braces: { and }
    • Brackets: [ and ]
Note the grouping symbols cannot overlap. For example, (a{b)} is illegal.
Write a program to check whether a Java source-code file has correct pairs of grouping symbols.
Pass the source-code file name as a command-line argument.

Sample Run for Exercise20_11.java
Execution Result:
---
public class Welcome {
	public static void main(String[] args) {
		// Display message Welcome to Java! on the console
		System.out.println("Welcome to Java!");
	}
}
Correct grouping pairs
*/

// Imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class M04_Assignment_1 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java M04_Assignment_1.java");
            System.exit(1);
        }

        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("File " + args[0] + " does not exist.");
            System.exit(2);
        }

        try (Scanner input = new Scanner(file)) {
            Stack<Character> stack = new Stack<>();
            boolean isCorrect = true;
            int lineNumber = 0;

            while (input.hasNextLine()) {
                String line = input.nextLine();
                lineNumber++;

                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);

                    // Push opening symbols onto the stack
                    if (ch == '(' || ch == '{' || ch == '[') {
                        stack.push(ch);
                    } 
                    // Check for matching closing symbols
                    else if (ch == ')' || ch == '}' || ch == ']') {
                        if (stack.isEmpty()) {
                            System.out.println("Unmatched closing symbol '" + ch + "' at line " + lineNumber);
                            isCorrect = false;
                            break;
                        }

                        char open = stack.pop();
                        if (!isMatchingPair(open, ch)) {
                            System.out.println("Mismatched symbol '" + open + "' with '" + ch + "' at line " + lineNumber);
                            isCorrect = false;
                            break;
                        }
                    }
                }
            }

            if (isCorrect && stack.isEmpty()) {
                System.out.println("Correct grouping pairs");
            } else if (!stack.isEmpty()) {
                System.out.println("Unmatched opening symbol(s): " + stack);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Helper method to match pairs
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
}
