package ArrayAndString;

import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
    	int[] high_digit = {1};
    	if(digits==null||digits.length==0) return high_digit;
        // Note: The Solution object is instantiated only once and is reused by each test case.
        for(int i=digits.length-1;i>=0;--i) {
        	digits[i]++;
        	if(digits[i]<=9) return digits;
        	else {
        		digits[i] = 0;
        	}
        }
        digits[0] = 0;
        int[] results = new int[digits.length+1];
        results[0] = 1;
        for(int i=1;i<results.length;++i)
        	results[i] = digits[i-1];
        return results;
    }
    
    public static void main(String[] args) {
    	int[] digits = {0,9,9};
    	System.out.println(Arrays.toString(plusOne(digits)));
    }
}
