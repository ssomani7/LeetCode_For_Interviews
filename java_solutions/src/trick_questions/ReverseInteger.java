package trick_questions;

/*
 * Time Complexity: O(log(x)). There are roughly log (x) digits in xx.
                                                    10
   Space Complexity: O(1).
 */

/*
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Example 1:
 * Input: 123
 * Output: 321
 * 
 * Example 2:
 * Input: -123
 * Output: -321
 * 
 * Example 3:
 * Input: 120
 * Output: 21
 * 
 * Note: 
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer
 * range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the 
 * reversed integer overflows.
 * 
 */

public class ReverseInteger {

	public static int reverseIntegerWithoutOverflow(int x) {
		int result = 0;
		
		while(x != 0) {
			int lastDigit = x % 10;
			int newResult = result * 10 + lastDigit;
			
			if((newResult - lastDigit) / 10 != result) //tricky part
				return 0;
			
			result = newResult;
			x = x / 10;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int x = -123;
		
		System.out.println("Reversed Integer without overflow = " + reverseIntegerWithoutOverflow(x));
	}

}
