/* Module 3: Assignment 1
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/8/25
File:   Circle.java
*/

/* 13.9 (Enable Circle comparable)
Rewrite the Circle class in LiveExample 13.2 to extend GeometricObject and implement the Comparable interface.
Override the equals method in the Object class. Two Circle objects are equal if their radii are the same.
Draw the UML diagram that involves Circle, GeometricObject, and Comparable.
*/

public class Circle extends GeometricObject implements Comparable<Circle> {
	private double radius;
	
	// Constructor
	public Circle (double radius) {
		this.radius = radius;
	}
	
	// Radius
	/** Return Radius */
	public double getRadius() {
		return radius;
	}
	/** Set a new radius */
	public void setRadius (double radius){
		this.radius = radius;
	}
	
	// Calculations
	@Override /** Return Area */
	public double getArea() {
		return radius * radius * Math.PI;
	}
	/** Return a diameter */
	public double getDiameter() {
		return 2 * radius;
	}
	@Override /** Return Perimeter */
	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}
	
	/* Print the circle info */
	public void printCircle() {
		System.out.println("The circle is created " + getDateCreated() + " and the radius is " + radius);
	}

	/** Comparable implementation */
	@Override
	public int compareTo (Circle other) {
		return Double.compare(this.radius, other.radius);
	}

	/** Override equals */
	@Override
	public boolean equals (Object obj) {
		if (this == obj) {
			return true; // same object
		}
		if (!(obj instanceof Circle)) {
			return false; // not a circle
		}
		Circle other = (Circle) obj;
		return Double.compare(this.radius, other.radius) == 0;
	}
}
