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

public class Circle FILL_CODE_OR_CLICK_ANSWER {
	private double radius;
	
	public Circle (double radius) {
		this.radius = radius;
	}
	
	/** Return Radius */
	public double getRadius() {
		return radius;
	}
	
	/** Set a new radius */
	public void setRadius (double radius){
		this.radius = radius;
	}
	
	@Override /** Return Area */
	FILL_CODE_OR_CLICK_ANSWER {
		return radius * radius * Math.PI;
	}
	
	/** Return a diameter */
	public double getDiameter() {
		return 2 * radius;
	}
	
	@Override /** Return Perimeter */
	FILL_CODE_OR_CLICK_ANSWER {
		return 2 * radius * Math.PI;
	}
	
	/* Print the circle info */
	public void printCircle() {
		System.out.println("The circle is created " + getDateCreated() + " and the radius is " + radius);
	}
}
