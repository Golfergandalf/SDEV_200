/* Module 4: Assignment 2
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/8/25
File:   CountKeywords.java
*/

/* 21.3 (Count the keywords in Java source code)
Revise the program in LiveExample 21.7.
If a keyword is in a comment or in a string, don’t count it. Pass the Java file name from the command line.
Assume the Java source code is correct and line comments and paragraph comments do not overlap.

Sample Run for M04_Assignment_2.java
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
------------------------------------------------------------------------------
Sample Run for CountKeywords.java
Execution Result:
---
JDK8>javac CountKeywords.java
Compiled successful

JDK8>java CountKeywords
Enter a Java source file: c:\book\Welcome.java
The number of keywords in c:\book\Welcome.java is 5
------------------------------------------------------------------------------
The program prompts the user to enter a Java source filename (line 7) and reads the filename (line 8). If the file exists, the countKeywords method is invoked to count the keywords in the file (line 13).
The countKeywords method creates an array of strings for the keywords (lines 22–31) and creates a hash set from this array (lines 33–34). It then reads each word from the file and tests if the word is in the set (line 41). If so, the program increases the count by 1 (line 42).
You may rewrite the program to use a LinkedHashSet, TreeSet, ArrayList, or LinkedList to store the keywords. However, using a HashSet is the most efficient for this program.
*/

import java.util.*;
import java.io.*;

public class CountKeywords {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a Java source file: ");
		String filename = input.nextLine();
		
		File file = new File(filename);
		if (file.exists()) {
			System.out.println("The number of keywords in " + filename + " is " + countKeywords(file));
		} else {
			System.out.println("File " + filename + " does not exist");
		}

		// Make the input error go away
        input.close();
	}
	
	public static int countKeywords(File file) throws Exception {
		// Array of all Java keywords + true, false, and null
		String[] keywordString = {"abstract", "assert", "boolean", 
			"break", "byte", "case", "catch", "char", "class", "const", 
			"continue", "default", "do", "double", "else", "enum", 
			"extends", "for", "final", "finally", "float", "goto", 
			"if", "implements", "import", "instanceof", "int", 
			"interface", "long", "native", "new", "package", "private", 
			"protected", "public", "return", "short", "static", 
			"strictfp", "super", "switch", "synchronized", "this", 
			"throw", "throws", "transient", "try", "void", "volatile", 
			"while", "true", "false", "null"};
		
		Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
		int count = 0;
		
		Scanner input = new Scanner(file);
		
		while (input.hasNext()) {
			String word = input.next();
			if (FILL_CODE_OR_CLICK_HERE) { // Test if word is a keyword
				count++;
			}
		}
		
		return count;
    }
}
