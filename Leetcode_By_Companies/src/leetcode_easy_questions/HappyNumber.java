package leetcode_easy_questions;

/*
 * Time complexity : O(logn). Builds on the analysis for the previous approach, except this time we need to analyse
 * how much extra work is done by keeping track of two places instead of one, and how many times they'll need to go
 * around the cycle before meeting.
 * 
 * If there is no cycle, then the fast runner will get to 1, and the slow runner will get halfway to 1. Because 
 * there were 2 runners instead of 1, we know that at worst, the cost was O(2.log n) = O(logn).
 * 
 * Like above, we're treating the length of the chain to the cycle as insignificant compared to the cost of 
 * calculating the next value for the first n. Therefore, the only thing we need to do is show that the number of 
 * times the runners go back over previously seen numbers in the chain is constant.
 * 
 * Once both pointers are in the cycle (which will take constant time to happen) the fast runner will get one step
 * closer to the slow runner at each cycle. Once the fast runner is one step behind the slow runner, they'll meet 
 * on the next step. Imagine there are kk numbers in the cycle. If they started at k - 1k−1 places apart (which is
 * the furthest apart they can start), then it will take k - 1k−1 steps for the fast runner to reach the slow 
 * runner, which again is constant for our purposes. Therefore, the dominating operation is still calculating the
 * next value for the starting n, which is O(logn).
 * 
 * Space complexity : O(1). For this approach, we don't need a HashSet to detect the cycles. The pointers require
 * constant extra space.
 */

/*
 * Write an algorithm to determine if a number n is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the 
 * number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in
 * 1 are happy numbers.
 * 
 * Return True if n is a happy number, and False if not.
 * 
 * Example: 
 * Input: 19
 * Output: true
 * Explanation: 
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class HappyNumber {

    public static boolean isHappy(int n) {
        //Floyd's cycle detection algorithm
        int slowRunner = n;
        int fastRunner = getNextNumber(n);
        
        //Guranteed that fastRunner and slowRunner will meet. We need to only look for fastRunner. If it comes
        //across '1' means number will be happy as per the problem statement.
        while(fastRunner != 1 && slowRunner != fastRunner){
            slowRunner = getNextNumber(slowRunner);
            fastRunner = getNextNumber(getNextNumber(fastRunner));
        }
        
        return fastRunner == 1; //if fastRunner != 1, we will return false
    }
    
    public static int getNextNumber(int n){
        int squaredProduct = 0;
        
        while(n > 0){
            int lastDigit = n % 10;
            squaredProduct += lastDigit * lastDigit;
            n = n / 10;
        }
        return squaredProduct;
    }
    
	public static void main(String[] args) {
		int happyNumber = 19;
		System.out.println("Happy Number Existance = " + isHappy(happyNumber));
	}

}
