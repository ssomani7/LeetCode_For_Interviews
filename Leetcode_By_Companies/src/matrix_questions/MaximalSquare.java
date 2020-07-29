package matrix_questions;

/*
 * Time Complexity = O(M x N)
 * Space Complexity = O(M x N)
 */

/*
 * Approach:
 * Consider a 2 x 2 square. 
 *          1 1
 *          1 1
 * if we look at position [0][0] and look towards right, diagonal, down for 1 & if we find all ones, then we 
 * can say that it is a square of 2 x 2.
 * 
 * Now assume we want to check for 3 x 3 from  2 x 2
 *         1 1 1
 *         1 1 1
 *         1 1 1
 * Here for each element in the right and botton side of previous square we need to look towards right,
 * diagonal, down for 1. If all satisfy it we can say it is a 3 x 3 square.
 * 
 * So we encounter solving sub problems here. Since it is a square, we can even look for elements at left,
 * diagonal (left upwards) and top for 1, making our search sides to be left and top of the square.
 * 
 * We don't need to consider a square if any element on our search side is 0. So we will take minimum of
 * left, diagonal & top and add 1 to it. So in this DP fashion we will get our max square length.
 * 
 * Since there is nothing to the left, diagonal (left updwards) & right of the first matrix element, we make
 * our DP[][] of size '+1' on row & columns, so that the first element can look behind for left, diagonal (left
 * upwards) and right.	
 */

/*
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its
 * area.
 * 
 * Example:
 * Input: 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 
 * Output: 4
 */

public class MaximalSquare {

	public static int maxSquareArea(char[][] matrix) {
		int maxSideLength = 0;
		int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
		
		for(int row = 1; row < dp.length; row++) {
			for(int col = 1; col < dp[0].length; col++) {
				if(matrix[row - 1][col - 1] == '1') {
					//look in dp 3 sides, left, diagonal (left upwards) and top
					//take minimum of those 3 and add 1
					//update the maxSideLength variable
					dp[row][col] = 1 + Math.min(dp[row - 1][col], Math.min(dp[row - 1][col - 1], 
																		   dp[row][col - 1]));
					maxSideLength = Math.max(maxSideLength, dp[row][col]);
				}
			}
		}
			
		return maxSideLength * maxSideLength; //default
	}
	
	public static void main(String[] args) {
		char[][] matrix = {
				{'1', '0', '1', '0', '0'},
				{'1', '0', '1', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '0', '0', '1', '0'}
		};
		
		System.out.println("Maximum Square Area = " + maxSquareArea(matrix));
	}

}
