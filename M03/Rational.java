/* Module 3: Assignment 2
Name:   Gabby Willard
Class:  SDEV 200
Date:   9/8/25
File:   Rational.java
*/

public class Rational extends Number implements FILL_CODE_OR_CLICK_ANSWER {
	// Data fields for numerator and denominator
	private long numerator = 0;
	private long denominator = 1;
	
	/** Construct a rational with default properties */
	public Rational() {
		FILL_CODE_OR_CLICK_ANSWER;
	}
	
	/** Construct a rational with specified numerator and denominator */
	public Rational (long numerator, long denominator) {
		long gcd = gcd(numerator, denominator);
		this.numerator = FILL_CODE_OR_CLICK_ANSWER
		this.denominator = Math.abs(denominator) / gcd;
	}
	
	/** Find GCD of two numbers */
	private static long gcd (long n, long d) {
		long n1 = Math.abs(n);
		long n2 = Math.abs(d);
		int gcd = 1;
		
		for (int k = 1; k <= n1 && k <= n2; k++) {
			if (n1 % k == 0 && n2 % k == 0) {
				gcd = k;
			}
		}
		return gcd;
	}
	
	/** Return numerator */
	public long getNumerator() {
		return numerator;
	}
	
	/** Return denominator */
	public long getDenominator() {
		return denominator;
	}
	
	/** Add a rational number to this rational */
	public Rational add (Rational secondRational) {
		long n = numerator * secondRational.getDenominator() + denominator * secondRational.getNumerator();
		long d = denominator * secondRational.getDenominator();
		return FILL_CODE_OR_CLICK_ANSWER;
	}
	
	/** Subtract a rational number from this rational */
	public Rational subtract (Rational secondRational) {
		long n = numerator * secondRational.getDenominator() - denominator * secondRational.getNumerator();
		long d = denominator * secondRational.getDenominator();
		return new Rational(n, d);
	}
	
	/** Multiply a rational number from this rational */
	public Rational multiply (Rational secondRational) {
		long n = FILL_CODE_OR_CLICK_ANSWER;
		long d = denominator * secondRational.getDenominator();
		return new Rational(n, d);
	}
	
	/** Divide a rational number from this rational */
	public Rational divide (Rational secondRational) {
		long n = numerator * secondRational.getDenominator();
		long d = denominator * secondRational.numerator();
		return new Rational(n, d);
	}
	
	@Override // Override toString()
	FILL_CODE_OR_CLICK_ANSWER {
		if (denominator == 1) {
			return numerator + "";
		} else {
			return numerator + "/" + denominator;
		}
	}
	
	@Override // Override the equals method in the Object class
	FILL_CODE_OR_CLICK_ANSWER {
		if ((this.subtract((Rational)(other))).getNumerator() == 0) {
			return true;
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
		return numerator * 1.0 / denominator;
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
