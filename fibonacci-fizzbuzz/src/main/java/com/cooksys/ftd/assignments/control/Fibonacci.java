package com.cooksys.ftd.assignments.control;

import com.cooksys.ftd.assignments.control.util.MissingImplementationException;

/**
 * The Fibonacci sequence is simply and recursively defined: the first two elements are `1`, and
 * every other element is equal to the sum of its two preceding elements. For example:
 * <p>
 * [1, 1] =>
 * [1, 1, 1 + 1]  => [1, 1, 2] =>
 * [1, 1, 2, 1 + 2] => [1, 1, 2, 3] =>
 * [1, 1, 2, 3, 2 + 3] => [1, 1, 2, 3, 5] =>
 * ...etc
 */
public class Fibonacci {

    /**
     * Calculates the value in the Fibonacci sequence at a given index. For example,
     * `atIndex(0)` and `atIndex(1)` should return `1`, because the first two elements of the
     * sequence are both `1`.
     *
     * @param i the index of the element to calculate
     * @return the calculated element
     * @throws IllegalArgumentException if the given index is less than zero
     */
    public static int atIndex(int i) throws IllegalArgumentException {
        if(i<0) {
        	throw new IllegalArgumentException();
        }
        
        int[] fib = new int[] {1,1};
        int current = 1;
        
        for(int j=0; j<i-1; j++) {
        	int temp[] = new int[fib.length + 1];

        	current = fib[fib.length-2] + fib[fib.length-1];
        	for(int k=0; k<fib.length; k++) {
        		temp[k] = fib[k];
        	}
        	temp[temp.length - 1] = current;
        	fib = temp;
        }
        
        return current;
    }

    /**
     * Calculates a slice of the fibonacci sequence, starting from a given start index (inclusive) and
     * ending at a given end index (exclusive).
     *
     * @param start the starting index of the slice (inclusive)
     * @param end   the ending index of the slice(exclusive)
     * @return the calculated slice as an array of int elements
     * @throws IllegalArgumentException if either the given start or end is negative, or if the
     *                                  given end is less than the given start
     */
    public static int[] slice(int start, int end) throws IllegalArgumentException {
    	if(start<0 | end<0) {
        	throw new IllegalArgumentException();
        }
    	
    	int arraySize = end - start;
        int[] fibSequence = new int[arraySize];
        int index = 0;
        
        for(int i=start; i<end; i++) {
            fibSequence[index] = atIndex(i);
            index += 1;
        }
        return fibSequence;
    }

    /**
     * Calculates the beginning of the fibonacci sequence, up to a given count.
     *
     * @param count the number of elements to calculate
     * @return the beginning of the fibonacci sequence, up to the given count, as an array of int elements
     * @throws IllegalArgumentException if the given count is negative
     */
    public static int[] fibonacci(int count) throws IllegalArgumentException {
    	if(count < 0) {
        	throw new IllegalArgumentException();
        }
    	
    	if(count == 0) {
    		int[] fib = new int[count];
    		return fib;
    	}else if(count == 1) {
    		int[] fib = new int[] {1};
    		return fib;
    	}else if(count == 2) {
    		int[] fib = new int[] {1,1};
    		return fib;
    	}else {
        	int[] fib = new int[] {1,1};
            int current = 1;
            
            for(int j=0; j<count-2; j++) {
            	int temp[] = new int[fib.length + 1];

            	current = fib[fib.length-2] + fib[fib.length-1];

            	for(int k=0; k<fib.length; k++) {
            		temp[k] = fib[k];
            	}
            	temp[temp.length - 1] = current;
            	fib = temp;
            }
//            System.out.println("JAVA SUCKS");
//            System.out.println(fib.length);
            return fib;	
    	}
    }
    
    public static void main(String args[]) {
    	// 0 1 2 3 4 5 6  7  8  9  10
    	//[1,1,2,3,5,8,13,21,34,55,89 ....]
//    	int[] finalnAnswer = slice(7,11); 
//        
//    	for(int k=0; k<finalnAnswer.length; k++) {
//        	System.out.println(finalnAnswer[k]);
//        }
    	
    	int[] finalnAnswer = fibonacci(5); 
        
    	for(int k=0; k<finalnAnswer.length; k++) {
        	System.out.println(finalnAnswer[k]);
        }
    	
    }
}
