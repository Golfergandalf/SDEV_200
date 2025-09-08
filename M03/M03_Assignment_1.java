/* Module 3: Assignment 1
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/8/25
File:   M03_Assignment_1.java
*/

/* 13.9 (Enable Circle comparable)
Rewrite the Circle class in LiveExample 13.2 to extend GeometricObject and implement the Comparable interface.
Override the equals method in the Object class. Two Circle objects are equal if their radii are the same.
Draw the UML diagram that involves Circle, GeometricObject, and Comparable.
*/

public class M03_Assignment_1 {
    public static void main(String[] args) {

        // Circle Objects
        Circle c1 = new Circle(5);
        Circle c2 = new Circle(7);
        Circle c3 = new Circle(5);

        // Areas
        System.out.println("c1 area: " + c1.getArea());
        System.out.println("c2 area: " + c2.getArea());

        // Equals
        System.out.println("c1 equals c2? " + c1.equals(c2));
        System.out.println("c1 equals c3? " + c1.equals(c3));

        // Compare
        System.out.println("compare c1 to c2: " + c1.compareTo(c2));
        System.out.println("compare c1 to c3: " + c1.compareTo(c3));
    }
}
