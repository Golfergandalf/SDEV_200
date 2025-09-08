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
