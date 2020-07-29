package mathematics;

/* Dynammic Programming
 * Time Complexity = O(n)
 * Space Complexity = O(n)
 */

/*
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 * Example: Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * 
 * Note:  1 is typically treated as an ugly number.
 * n does not exceed 1690.
 */

/*
 * Approach:
 * Imagine you have multiplication tables of 2, 3, and 5
 * 
 * 2 x 1 = 2      3 x 1 = 3      5 x 1 = 5
 * 2 x 2 = 4      3 x 2 = 6      5 x 2 = 10
 * 2 x 3 = 6      3 x 3 = 9      5 x 3 = 15
 * 2 x 4 = 8      3 x 4 = 12      5 x 4 = 20
 * so on ....
 *  
 * Now let's say you have 3 pointers, i2, i3, i5 which initially all point to first entry in their respective
 * multiplication table.
 * 
 *  So for ugly number we take the minimum of each entry across all the three multiplication table and fill our
 *  dp array. So here the minimum between 2, 3, 5 is 2. So our dp[1] = 2. This is our new ugly number.
 *  
 *  Now we compare the new ugly number with the current entries of 2, 3, 5. And wherever we get a match, we
 *  go down (increase) the pointer of that table and update our multiple for that table.
 *  
 *  In this linear fashion, we fill up our dp array and the last element value in the array  is our answer.
 *  
 *  Tricky part is incrementing the pointer for a respective table and using it as an index to look up the
 *  multiplying value with 2, 3, or 5. We do this to keep a sync of values represented for each group where
 *  our pointers would be at different levels.
 *  
 *  Dry run it or see the tech dose video. Easy solution, tricky implementation.
 */

public class NthUglyNumber {

    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1; //special case
        
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        
        int next_multiple_of_2 = 2 * dp[i2]; //2 x 1 = 2
        int next_multiple_of_3 = 3 * dp[i3]; //3 x 1 = 3
        int next_multiple_of_5 = 5 * dp[i5]; //5 x 1 = 5
        
        for(int i = 1; i < n; i++){
            int newUglyNumber = Math.min(next_multiple_of_2, Math.min(next_multiple_of_3, 
                                                                     next_multiple_of_5));
            dp[i] = newUglyNumber;
            
            if(newUglyNumber == next_multiple_of_2){
                i2++;
                next_multiple_of_2 = 2 * dp[i2];
            }
            
            if(newUglyNumber == next_multiple_of_3){
                i3++;
                next_multiple_of_3 = 3 * dp[i3];
            }
            
            if(newUglyNumber == next_multiple_of_5){
                i5++;
                next_multiple_of_5 = 5 * dp[i5];
            }
        }
        
        return dp[n - 1];
    }
	
	public static void main(String[] args) {
		int num = 10;
		System.out.println(nthUglyNumber(num));
	}

}
