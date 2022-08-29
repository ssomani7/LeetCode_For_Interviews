package mathematics;

/*
 * Time complexity: O(n x sqrt(n)). In main step, we have a nested loop, where the outer loop is of n 
 * iterations and in the inner loop it takes at maximum sqrtn iterations.
 * 
 * Space Complexity: O(n). We keep all the intermediate sub-solutions in the array dp[].
 */

/*
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...)
 * which sum to n.
 * 
 * Example 1:
 * Input: n = 12
 * Output: 3 
 * 
 * Explanation: 12 = 4 + 4 + 4.
 * 
 * Example 2:
 * Input: n = 13
 * Output: 2
 * 
 * Explanation: 13 = 4 + 9.
 */

public class PerfectSquares {

    public static int numSquares(int n) {
        if(n <= 3)
            return n;
        
        int possiblePerfectSquare = (int) Math.sqrt(n);
        
        //Example: 25 = 5's square (5x5), so directly return 1
        if(possiblePerfectSquare * possiblePerfectSquare == n)
        	return 1;
        
        //for every positive integer, it can be represented as sum of 1 squares.
        //Ex: 7 = 1 + 1 + 1 + 1 + 1 + 1 + 1, 7 times, so this is the worst case for every element.
        //We need to minimize this.
        
        int[] dp = new int[n + 1]; //elements at dp[i] represent the number of elements required to
        //sum up that number, which is represented by its index.
        
        dp[0] = 0;
        dp[1] = 1; // 1 = 1. In terms of perfect square addition
        dp[2] = 2; // 2 = 1 + 1. No other combination is possible
        dp[3] = 3; // 3 = 1 + 1 + 1. No other combination is possible
        
        for(int i = 4; i <= n; i++){
            dp[i] = i; //starting with the worst case of number of 1's square
            //Since we need to add only perfect square count, we look back into our dp array which has stored
            //only perfect sqaure count for that particular number represented by index.
            //So we reduce (j x j) from i to get the perfect square count. jxj cannot be greater than 'i'
            //because we will run out of array index bounds.
            
            //So first j = 1, so it will be [i - 1], that is we look at the value right before 'i'
            //then j = 2, so we will look at the value from the index[i -jxj]
            //in this fashion we use the sub problems to solve the bigger problem, so dynammic programming
            for(int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        
        return dp[n];
    }
	
	public static void main(String[] args) {
		int n = 13;
		System.out.println(numSquares(n));
	}

}
