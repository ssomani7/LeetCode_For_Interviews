package matrix_questions;

/*
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes
 * the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * 
 * Example:
 * Input:
 * [
 *  [1,3,1],
 *  [1,5,1],
 *  [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */

public class MinimumPathSum {
	
	//Time Complexity = O(M x N), we need to traverse the entire matrix once
	//Space Complexity = O(N), array of size (N + 1)
    public static int minPathSumSpaceOptimized(int[][] grid) {
		//edge case
		if(grid == null || grid.length == 0)
			return 0;
		
		int number_of_rows = grid.length;
		int number_of_columns = grid[0].length;
		
		//While traversing we just need to reference the state of cells on top of us and that to the left of us.
		//we can do this by maintaining a single array of length '#columns + 1' and keep updating it.
		int[] dp = new int[number_of_columns + 1];
		//'#columns + 1', because we need to take care of the 0th cell where it doesn't have any left cell to come
		//from.
    	
		//for the 0th row, there is only chance to come from left. So fill the dp[] array in that fashion.
		//grid[row][col] mapped to dp[index + 1].
		
		//dp[col] = act as left side cost
		//dp[col + 1] = act as top side cost
		
		//dp[col + 1] will act as the updated state of grid[row][col] after processing.
		for(int col = 0; col < number_of_columns; col++) {
			dp[col + 1] = dp[col] + grid[0][col];
		}
		
		//now for row 1 onwards, for 0th cell there is no alternative the choosing from the top. And when the
		//row and columns both are greater than 0, they will have 2 choices to choose minimum from, i.e, row - 1
		//and col -1.
		//So we will make dp[0] as Integer Max Value, so that, for 0th cell dp[col] which represents the previous
		//top cell is choosen in Math.min() method.
		dp[0] = Integer.MAX_VALUE;
		
		for(int row = 1; row < number_of_rows; row++) {
			for(int col = 0; col < number_of_columns; col++) {
				dp[col + 1] = Math.min(dp[col], dp[col + 1]) + grid[row][col];
			}
		}
    	
    	return dp[number_of_columns];
    }
	
	//Time Complexity = O(M x N), we need to traverse the entire matrix once
	//Space Complexity = O(M x N), for the dp matrix we maintained.
	
	public static int minPathSum(int[][] grid) {
		//edge case
		if(grid == null || grid.length == 0)
			return 0;
		
		int number_of_rows = grid.length;
		int number_of_columns = grid[0].length;
		int[][] dp = new int[number_of_rows][number_of_columns]; //initially all values are zero
		
		//we can only move downward and rightside. So from the cell perspective, we can only arrive it at either
		//from TOP or from LEFT side of it, i.e, row - 1 or col - 1.
		
		for(int row = 0; row < number_of_rows; row++) {
			for(int col = 0; col < number_of_columns; col++) {
				//first copy the initial state of the cell before any arrival.  
				dp[row][col] = grid[row][col];
								
				if(row == 0 && col > 0) {
					//for the 0th Row we cannot come from up, but we can come from left. So update the cost of the
					//that cell by adding in the left cell.
					dp[row][col] += dp[row][col - 1];	
				} else if(row > 0 && col == 0) {
					//from 1st Row for each 0th cell, we can only come from top. So update the cost of that cell by
					//adding the cell above it.
					dp[row][col] += dp[row - 1][col];
				} else if(row > 0 && col > 0) {
					//if we are in middle, so we can come from two positions, top (col - 1), and left (row - 1).
					//these cells will have its minimum value in their respective places. We just need to take the
					//minimum of those and add it to the cells current state and update it.
					dp[row][col] += Math.min(dp[row - 1][col], dp[row][col - 1]);
				}
			}
		}
		
		return dp[dp.length - 1][dp[0].length - 1];
	}
	
	public static void main(String[] args) {
		int[][] grid = {
				  {1,3,1},
				  {1,5,1},
				  {4,2,1}
		};
		
		System.out.println("Minimum Cost = " + minPathSum(grid));
		System.out.println("Space Optimized Method Cost = " + minPathSumSpaceOptimized(grid));
	}

}
