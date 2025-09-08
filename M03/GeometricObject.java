/* Module 3: Assignment 1
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/8/25
File:   GeometricObject.java
*/

/* 13.9 (Enable Circle comparable)
Rewrite the Circle class in LiveExample 13.2 to extend GeometricObject and implement the Comparable interface.
Override the equals method in the Object class. Two Circle objects are equal if their radii are the same.
Draw the UML diagram that involves Circle, GeometricObject, and Comparable.
*/

public abstract class GeometricObject {
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;
	
    // Constructors
	/** Construct a default geometric object */
	protected GeometricObject() {
		dateCreated = new java.util.Date();
	}
	/** Construct a geometric object with color and filled value */
	protected GeometricObject (String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}
	
    // Color
	/** Return color */
	public String getColor() {
		return color;
	}
	/** Set a new color */
	public void setColor (String color) {
		this.color = color;
	}
	
    // Filled
	/** Return filled. Since filled is boolean, the get method is named isFilled */
	public boolean isFilled() {
		return filled;
	}
	/** Set a new filled */
	public void setFilled (boolean filled) {
		this.filled = filled;
	}
	
	/** Get dateCreated */
	public java.util.Date getDateCreated() {
		return dateCreated;
	}
	
	@Override
	public String toString() {
		return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
	}
	
	/** Abstract method getArea */
	public abstract double getArea();

	/** Abstract method getPerimeter */
	public abstract double getPerimeter();
}
