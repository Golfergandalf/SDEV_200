/* Module 3: Assignment 2
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/8/25
File:   Rational.java
*/

/* 13.15 (Use BigInteger for the Rational class) 
Redesign and implement the Rational class in LiveExample 13.13 using BigInteger for the numerator and denominator.
Write a test program that prompts the user to enter two rational numbers and display the results as shown in the following sample run:
Sample Run for Exercise13_15.java
---
Enter the input for the program (Sample data provided below. You may modify it.)
343 531
4912 9347
---
Execution Result:
---
Enter rational r1 with numerator and denominator separated by a space: 343 531
Enter rational r2 with numerator and denominator separated by a space: 4912 9347
343/531 + 4912/9347 = 5814293/4963257
343/531 - 4912/9347 = 597749/4963257
343/531 * 4912/9347 = 1684816/4963257
343/531 / 4912/9347 = 3206021/2608272
4912/9347 is 0.5255162084091152
*/

import java.math.BigInteger;

public class Rational extends Number implements Comparable<Rational> {

    // Variables
	// Data fields for numerator and denominator
	private BigInteger numerator = BigInteger.ZERO;
	private BigInteger denominator = BigInteger.ONE;
	

    // Constructors
	/** Construct a rational with default properties */
	public Rational() {
		this(BigInteger.ZERO, BigInteger.ONE);
	}
	/** Construct a rational with specified numerator and denominator */
	public Rational (BigInteger numerator, BigInteger denominator) {
        if (denominator.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Denominator cannot be zero.");
        }
        BigInteger gcd = numerator.gcd(denominator);
        // Ensure denominator is positive
        if (denominator.compareTo(BigInteger.ZERO) < 0) {
            gcd = gcd.negate();
        }
		this.numerator = numerator.divide(gcd);
		this.denominator = denominator.divide(gcd);
	}
	
    // Get Methods
	/** Return numerator */
	public BigInteger getNumerator() {
		return numerator;
	}
	/** Return denominator */
	public BigInteger getDenominator() {
		return denominator;
	}
	

    // Calculation Methods
	/** Add a rational number to this rational */
	public Rational add (Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator()).add(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getNumerator());
        return new Rational(n, d);
	}
	/** Subtract a rational number from this rational */
	public Rational subtract (Rational secondRational) {
		BigInteger n = numerator.multiply(secondRational.getDenominator()).subtract(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getNumerator());
		return new Rational(n, d);
	}
	/** Multiply a rational number from this rational */
	public Rational multiply (Rational secondRational) {
		BigInteger n = numerator.multiply(secondRational.getNumerator());
        BigInteger d = denominator.multiply(secondRational.getDenominator());
		return new Rational(n, d);
	}
	/** Divide a rational number from this rational */
	public Rational divide (Rational secondRational) {
		if (secondRational.getNumerator().equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Division by zero");
        }
        BigInteger n = numerator.multiply(secondRational.getDenominator());
        BigInteger d = denominator.multiply(secondRational.getNumerator());
		return new Rational(n, d);
	}
	

    // Overrides
	@Override // Override toString()
	public String toString() {
		if (denominator.equals(BigInteger.ONE)) {
			return numerator.toString();
		} else {
			return numerator + "/" + denominator;
		}
	}
	@Override // Override the equals method in the Object class
	public boolean equals (Object other) {
		if (other instanceof Rational) {
            Rational o = (Rational) other;
            return numerator.equals(o.getNumerator()) && denominator.equals(o.getDenominator());
        } else {
            return false;
        }
	}
	@Override // Implement the abstract intValue method in Number
	public int intValue() {
		return (int)doubleValue();
	}
	@Override // Implement the abstract floatValue method in Number
	public float floatValue() {
		return (float)doubleValue();
	}
	@Override // Implement the doubleValue method in Number
	public double doubleValue() {
		return numerator.doubleValue() / denominator.doubleValue();
	}
	@Override // Implement the abstract longValue method in Number
	public long longValue() {
		return (long)doubleValue();
	}
	
	@Override // Implement the compareTo method in Comparable
	FILL_CODE_OR_CLICK_ANSWER {
		if (this.subtract(o).getNumerator() > 0) {
			return 1;
		} else if (this.subtract(o).getNumerator() < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}
