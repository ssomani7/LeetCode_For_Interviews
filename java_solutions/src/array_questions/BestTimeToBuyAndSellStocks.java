package array_questions;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 * Kadane's Algorithm Approach.
 * 
 */
public class BestTimeToBuyAndSellStocks {

	public static int peekAndValleyGraph(int[] prices) {
		int minimumPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		
		for(int index = 0; index < prices.length; index++) {
			if(prices[index] < minimumPrice)
				minimumPrice = prices[index];
			else if (prices[index] - minimumPrice > maxProfit)
				maxProfit = prices[index] - minimumPrice;
		}
		
		return maxProfit;
	}
	
    public static int maxProfit(int[] prices) {
        int maxCur = 0;
        int maxSoFar = 0;
        
        for(int i = 1; i < prices.length; i++) {
        	//maxCur will be set to zero if it drops below zero. In this algorithm, we calculate the maxCur linearly
        	//and keep adding it to sell - buy, i.e, [i] and [i - 1].
        	//So we get the max profit in the end as the aggregate.
        	maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
    
	public static void main(String[] args) {
//		int[] prices = {7,1,5,3,6,4};
		int[] prices = {500, 400, 600, 100, 100, 400, 200, 800};
		System.out.println(maxProfit(prices));
		
		System.out.println(peekAndValleyGraph(prices));
	}

}
