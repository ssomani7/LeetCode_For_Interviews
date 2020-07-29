package binarySearch;

/*
 * Time complexity : O(logN).
 * Space complexity : O(1). 
 */

/*
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have 
 * exactly k coins.
 * 
 * Given n, find the total number of full staircase rows that can be formed.
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 * 
 * Example 1:
 * n = 5
 * 
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * 
 * Because the 3rd row is incomplete, we return 2.
 * Example 2:
 * 
 * n = 8
 * 
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * 
 * Because the 4th row is incomplete, we return 3.
 */

/*
 * This question is easy in a sense that one could run an exhaustive iteration to obtain the result. That 
 * could work, except that it would run out of time when the input becomes too large. So let us take a step 
 * back to look at the problem, before rushing to the implementation.
 * 
 * Assume that the answer is k, i.e. we've managed to complete k rows of coins. These completed rows contain 
 * in total 1+2+...+k= k(k+1) / 2 coins.
 * 
 * We could now reformulate the problem as follows:
 * 
 * Find the maximum k such that k(k+1)/2 <= N
 * 
 * The problem seems to be one of those search problems. And instead of naive iteration, one could resort to 
 * another more efficient algorithm called binary search, as we can find in another similar problem called 
 * search insert position.
 */

public class ArrangingCoins {

    public static int arrangeCoins(int n) {
        //sum is going like 1+2+3...+K, where we expect K to be our answer
        //So this is K x (K + 1) / 2
        //Doing Binary Search
        
        //Taking long because of huge inputs causing out of range problems for Integer
        long left = 0;
        long right = n;
        long current = 0;
        long K = 0;
        
        while(left <= right){
            K = left + (right - left) / 2; //mid
            
            current = K * (K + 1) / 2;
            
            if(n == current)
                return (int) K; //important step here
            
            if(n < current)
                right = K - 1;
            else
                left = K + 1;
        }
        
        return (int)right;
    }
	
	public static void main(String[] args) {
		int n = 6;
		System.out.println(arrangeCoins(n));
	}

}
