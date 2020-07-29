package bitwise_operator;

/*
 * Time Complexity: O(1). Although there is a loop in the algorithm, the number of iterations is bounded by 
 * the number of bits that an integer has, which is fixed. Therefore, the time complexity of the algorithm is 
 * constant.
 * Space Complexity: O(1). The consumption of the memory for our algorithm is constant, regardless the input.
 */

/*
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range,
 * inclusive.
 * 
 * Example 1:
 * Input: [5,7]
 * Output: 4
 * 
 * Example 2:
 * Input: [0,1]
 * Output: 0
 */

public class BitwiseANDofNumberRange {

	public static int rangeBitwiseAnd(int m, int n) {
        int numberOfRightShifts = 0;
        
        //We are bitwise ANDing. So AND is only '1' when both the bits are 1. If either is zero, AND is
        //Zero.
        
        //So we will compare both 'm' and 'n'. For them to give '1' each of their bit has to be the
        //same. If they are not same, means there is some difference.
        
        //So we start right shifting, i.e, we delete the last bit of 'm' and 'n' and compare the new
        //'m' and 'n' for equality. Record the number of right shifts.
        
        //After right shifting we will reach a stage where 'm' and 'n' bits become same and we exit out
        //of while loop
        
        //Now choose any 'm' or 'n' that has been modified and left shift it number of times we right
        //shifted them to become similar. Left shift means adding zero at the right most side.
        
        //return this left shifted value.
        
        //Example:
        // m = 101 = 5
        // n = 111 = 7
        // count = 0
        // (m != n ) Right Shift & count++
        // m = 10
        // n = 11
        // (m != n ) Right Shift & count++
        // m = 1
        // n = 1
        // now chose any 'm' or 'n'
        // m left shift count
        // 1 << 2
        // 100 (4 in decimal) return
        
        while(m != n){
            m >>= 1;
            n >>= 1;
            numberOfRightShifts++;
        }
        
        return m << numberOfRightShifts;
    }
	
	public static void main(String[] args) {
		int m = 5;
		int n = 7;
				
		System.out.println("Bitwise AND of m = " + m + " to n = " + n + " ('n' inclusive) =  " + 
		rangeBitwiseAnd(m, n));
	}

}
