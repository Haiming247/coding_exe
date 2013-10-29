import java.util.ArrayList;

public class Division {

	public int divide(int dividend, int divisor) {
		boolean signA = dividend >= 0, signB = divisor > 0;
		long num = Math.abs((long) dividend), div = Math.abs((long) divisor), res = 0, curr = 0;
		// using Long division
		for (int idx = 31; idx >= 0; idx--) {
			curr <<= 1;
			curr |= ((num >> idx) & 1);

			res = res << 1;
			if (curr >= div) {
				curr -= div;
				res |= 1;
			}
		}

		if (signA ^ signB)
			return -(int) res;
		return (int) res;
	}

	public static void main(String args[]) {
		System.out.println(5/2);
		System.out.println((-5)/2);
		System.out.println(Math.pow(0, 0));
		System.out.println(Math.pow(-10, 0));
		System.out.println(Double.MAX_VALUE);

		Double myDouble = 1.1;

	}
}
