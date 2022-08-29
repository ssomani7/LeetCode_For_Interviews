package bitwise_operator;

/*
 * Time Complexity = O(1)
 * Space Complexity = O(1)
 */

/*
 * Intuition:
 * In Power of two, there is only one bit which is set to '1' all others are zero.
 * 
 * 2 Bitwise Algorithms. Both O(1) time and space
 * Faster Algorithm = take a bitwise '&' with one lesser number than the number given. If the given number is
 *                    is a power of two, then the '&' result will be NON ZERO and we can say that the given
 *                    number is a power of two. Here we don't need to take care of integer range but need to
 *                    handle edge case where given number must be greater than zero '0'
 *                    
 * Slower Algorithm = We solve it as per the problem statement. The standard left shifting of 1 from 0 to 31.
 *                    Each time our '&' of the left shifted number and the given number turns out to be non-zero
 *                    we increase the count of numberofOnes. Finally we check if numberOfOnes == 1, then it is
 *                    true, else false. Here we need to take care of the integer range problem.
 */

/*
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * Example 1:
 * Input: 1
 * Output: true 
 * Explanation: 20 = 1
 * 
 * Example 2:
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 * 
 * Example 3:
 * Input: 218
 * Output: false
 */

public class PowerOfTwo {

	public static boolean andingWithPreviousNumber(int n) {
		//edge case
		if(n <= 0)
			return false;
		
		//trick
		return (n & (n - 1)) == 0;
	}
	
	public static boolean countingNumberOfOnes(int n) {
        //edge case integer out of bounds for negative and positive
        //Because the range of an integer = -2147483648 (-2^31) ~ 2147483647 (2^31-1), the max possible 
        //power of two = 2^30 = 1073741824. 
        if(n <= Integer.MIN_VALUE || n >= Integer.MAX_VALUE)
            return false;
        
        int numberOfOnes = 0;
        //bit manipulation. 'i' represents offset on 32 bit for left shifting
        for(int i = 0; i < 32; i++){
            int leftShiftedNumber = (1 << i);
            
            if((n & leftShiftedNumber) != 0)
                numberOfOnes++;
        }
        
        return numberOfOnes == 1 ? true : false;
	}
	
	
	public static void main(String[] args) {
		int n = 4;
//		int n = 16;
//		int n = 218;
//		int n = 0;
//		int n = -2147483648;
		
		System.out.println("Anding with previous number = " + andingWithPreviousNumber(n));
		System.out.println("Counting number of ones = " + countingNumberOfOnes(n));
	}

}
