/* Module 4: Assignment 2
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/8/25
File:   M04_Assignment_2.java
*/

/* 21.3 (Count the keywords in Java source code)
Revise the program in LiveExample 21.7.
If a keyword is in a comment or in a string, don’t count it. Pass the Java file name from the command line.
Assume the Java source code is correct and line comments and paragraph comments do not overlap.

Sample Run for Exercise21_03.java
Execution Result:
---
The program is
public class Welcome {
	public static void main(String[] args) {
		// Display message welcome to Java! on the console
		System.out.println("Welcome to Java!");
	}
}
The number of keywords in the program is 5

*/

// Imports
import java.io.*;
import java.util.*;

public class M04_Assignment_2 {
    // Set of all Java keywords
    private static final Set<String> KEYWORDS = new HashSet<>(Arrays.asList(
        "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
        "class", "const", "continue", "default", "do", "double", "else", "enum",
        "extends", "for", "final", "finally", "float", "goto", "if", "implements",
        "import", "instanceof", "int", "interface", "long", "native", "new",
        "package", "private", "protected", "public", "return", "short", "static",
        "strictfp", "super", "switch", "synchronized", "this", "throw", "throws",
        "transient", "try", "void", "volatile", "while"
    ));

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java M04_Assignment_2.java");
            System.exit(1);
        }

        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("File " + args[0] + " does not exist.");
            System.exit(2);
        }

        int count = 0;
        boolean inBlockComment = false; // Tracks if we’re inside /* ... */
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                line = removeCommentsAndStrings(line, inBlockComment);

                // Check if block comment started or ended within the line
                if (line.contains("BLOCK_COMMENT_START")) {
                    inBlockComment = true;
                    line = line.replace("BLOCK_COMMENT_START", "");
                }
                if (line.contains("BLOCK_COMMENT_END")) {
                    inBlockComment = false;
                    line = line.replace("BLOCK_COMMENT_END", "");
                }

                if (!inBlockComment) {
                    String[] tokens = line.split("[\\s\\p{Punct}]+");
                    for (String token : tokens) {
                        if (KEYWORDS.contains(token)) {
                            count++;
                        }
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }

        System.out.println("The number of keywords in the program is " + count);
    }

    /**
     * Removes strings and comments from a single line.
     * Keeps track of block comment boundaries using special placeholders.
     */
    private static String removeCommentsAndStrings(String line, boolean inBlockComment) {
        StringBuilder sb = new StringBuilder();
        boolean inString = false;

        for (int i = 0; i < line.length(); i++) {
            if (!inString && !inBlockComment && i < line.length() - 1 && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                // Single-line comment: ignore rest of line
                break;
            }
            else if (!inString && !inBlockComment && i < line.length() - 1 && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                inBlockComment = true;
                sb.append("BLOCK_COMMENT_START");
                i++; // skip '*'
            }
            else if (inBlockComment && i < line.length() - 1 && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                inBlockComment = false;
                sb.append("BLOCK_COMMENT_END");
                i++; // skip '/'
            }
            else if (!inBlockComment) {
                if (line.charAt(i) == '"') {
                    inString = !inString; // toggle string state
                }
                // If not inside a string, keep character; if inside string, replace with space
                sb.append(inString ? ' ' : line.charAt(i));
            }
        }

        return sb.toString();
    }
}
