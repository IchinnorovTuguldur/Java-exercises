package com.cooksys.ftd.assignments.objects;
import com.cooksys.ftd.assignments.objects.util.MissingImplementationException;

public class SimplifiedRational implements IRational {
	
	public int numerator;
	public int denominator;
	
    /**
     * Determines the greatest common denominator for the given values
     *
     * @param a the first value to consider
     * @param b the second value to consider
     * @return the greatest common denominator, or shared factor, of `a` and `b`
     * @throws IllegalArgumentException if a <= 0 or b < 0
     */
    public static int gcd(int a, int b) throws IllegalArgumentException {
        if(a <= 0 | b < 0) {
        	throw new IllegalArgumentException();
        }
        
        int large = b;
        int small = a;
        
        if(a>b) {
        	large = a;
        	small = b;
        }
        
        int r = large % small;
        int q = (large - r)/small;
        while(r != 0) {
        	large = small;
        	small = r;
        	r = large % small;
        }
        return small;
    }

    /**
     * Simplifies the numerator and denominator of a rational value.
     * <p>
     * For example:
     * `simplify(10, 100) = [1, 10]`
     * or:
     * `simplify(0, 10) = [0, 1]`
     *
     * @param numerator   the numerator of the rational value to simplify
     * @param denominator the denominator of the rational value to simplify
     * @return a two element array representation of the simplified numerator and denominator
     * @throws IllegalArgumentException if the given denominator is 0
     */
    public static int[] simplify(int numerator, int denominator) throws IllegalArgumentException {
        if(denominator == 0) {
        	throw new IllegalArgumentException();
        }
        
        int[] answer = new int[2];
        
        int GCD = gcd(Math.abs(numerator), Math.abs(denominator));
        answer[0] = numerator/GCD;
        answer[1] = denominator/GCD;
        
        return answer;
    }

    /**
     * Constructor for rational values of the type:
     * <p>
     * `numerator / denominator`
     * <p>
     * Simplification of numerator/denominator pair should occur in this method.
     * If the numerator is zero, no further simplification can be performed
     *
     * @param numerator   the numerator of the rational value
     * @param denominator the denominator of the rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
    public SimplifiedRational(int numerator, int denominator) throws IllegalArgumentException {
    	 if(denominator == 0) {
         	throw new IllegalArgumentException();
         }
    	 this.numerator = numerator;
    	 this.denominator = denominator;
    	 
    	 if(numerator != 0) {
    		 int[] result = simplify(numerator, denominator);
    		 this.numerator = result[0];
    		 this.denominator = result[1];
    	 }
    }

    /**
     * @return the numerator of this rational number
     */
    @Override
    public int getNumerator() {
        return numerator;
    }

    /**
     * @return the denominator of this rational number
     */
    @Override
    public int getDenominator() {
        return denominator;
    }

    /**
     * Specializable constructor to take advantage of shared code between Rational and SimplifiedRational
     * <p>
     * Essentially, this method allows us to implement most of IRational methods directly in the interface while
     * preserving the underlying type
     *
     * @param numerator   the numerator of the rational value to construct
     * @param denominator the denominator of the rational value to construct
     * @return the constructed rational value (specifically, a SimplifiedRational value)
     * @throws IllegalArgumentException if the given denominator is 0
     */
    @Override
    public SimplifiedRational construct(int numerator, int denominator) throws IllegalArgumentException {
        if (denominator == 0) {
        	throw new IllegalArgumentException();
        }
        
        SimplifiedRational simplified = new SimplifiedRational(numerator, denominator);
        return simplified;
    }

    /**
     * @param obj the object to check this against for equality
     * @return true if the given obj is a rational value and its
     * numerator and denominator are equal to this rational value's numerator and denominator,
     * false otherwise
     */
    @Override
    public boolean equals(Object obj) {

        if(this == obj) {
        	return true;
        }
        if(obj == null) {
        	return false;
        }
        if(getClass() != obj.getClass()) {
        	return false;
        } 
        
        SimplifiedRational other = (SimplifiedRational) obj;
        
        if(other.getNumerator() == this.getNumerator() & other.getDenominator() == this.getDenominator()) {
        	return true;
        }
        
        return false;
        
    }

    /**
     * If this is positive, the string should be of the form `numerator/denominator`
     * <p>
     * If this is negative, the string should be of the form `-numerator/denominator`
     *
     * @return a string representation of this rational value
     */
    @Override
    public String toString() {
    	double number = Double.valueOf(this.numerator) / Double.valueOf(this.denominator);
    	String result = Integer.toString(Math.abs(this.numerator)) + "/" + Integer.toString(Math.abs(this.denominator));
        if(number < 0.0) {
        	result = "-" + result;
        }
        return result;
    }
    
    public static void main(String[] args) {
	}
}












