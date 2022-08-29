package mathematics;

/*
 * Time Complexity : O(logn) In each division performed in the while loop n is getting reduced by at least 
 * half. Input will become n n/2 n/4 n/8...1 so the runtime is O(logn)
 * Space Complexity : O(1)
 */

/*
 * Write a program to check whether a given number is an ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * Example 1:
 * Input: 6
 * Output: true
 * Explanation: 6 = 2 × 3
 * 
 * Example 2:
 * Input: 8
 * Output: true
 * Explanation: 8 = 2 × 2 × 2
 * 
 * Example 3:
 * Input: 14
 * Output: false 
 * Explanation: 14 is not ugly since it includes another prime factor 7.
 * 
 * Note:
 * 1 is typically treated as an ugly number.
 * Input is within the 32-bit signed integer range: [−231,  231 − 1].
 */

/*
 * Approach = Just divide by 2, 3 and 5 as often as possible and then check whether we arrived at 1.
 */

public class UglyNumber {

	public static boolean isUgly(int num) {
		if(num > 0)
			for(int i = 2; i < 6; i++) //Dividing by 2, 3, 5 (4 also included as it satisfies 2's properties)
				while(num % i == 0)
					num /= i;
		return num == 1;
    }
	
	public static void main(String[] args) {
		int num = 6;
		System.out.println(isUgly(num));
	}

}
