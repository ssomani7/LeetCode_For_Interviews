package leetcode_hard_questions;

/*
 * Time complexity : O(N x M). In each iteration over N we iterate over M a constant number of times.
 * Space complexity : O(M). M is the length of the additional arrays we keep.
 */

/*
 * Approach:
 * 
 * The DP solution proceeds row by row, starting from the first row. Let the maximal rectangle area at row i 
 * and column j be computed by [right(i,j) - left(i,j)] * height(i,j).
 * 
 * All the 3 variables left, right, and height can be determined by the information from previous row, and also 
 * information from the current row. So it can be regarded as a DP solution. The transition equations are:
 * 
 * left(i,j) = max(left(i-1,j), cur_left), cur_left can be determined from the current row
 * right(i,j) = min(right(i-1,j), cur_right), cur_right can be determined from the current row
 * height(i,j) = height(i-1,j) + 1, if matrix[i][j]=='1';
 * 
 * height(i,j) = 0, if matrix[i][j]=='0'
 * The code is as below. The loops can be combined for speed but I separate them for more clarity of the 
 * algorithm.
 */

import java.util.Arrays;

public class MaximalRectangle {
	
	public static int getMaximalRectangle(char[][] matrix) {
		//edge case
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) 
            return 0;
		
		int numberOfrows = matrix.length;
		int numberOfColumns = matrix[0].length;
		
		int[] left = new int[numberOfColumns];
		int[] right = new int[numberOfColumns];
		int[] height = new int[numberOfColumns];
		
		//Very Important Initialization
		Arrays.fill(right, numberOfColumns);
		
		int maxArea = 0;
		
		for(int row = 0; row < numberOfrows; row++) {
			int currentLeft = 0;
			int currentRight = numberOfColumns;
			
			//compute height (can do this from either side)
			for(int col = 0; col < numberOfColumns; col++) {
				if(matrix[row][col] == '1')
					height[col]++;
				else
					height[col] = 0;
			}
			
			//compute left (from left to right)
			for(int col = 0; col < numberOfColumns; col++) {
				if(matrix[row][col] == '1')
					left[col] = Math.max(left[col], currentLeft);
				else {
					left[col] = 0;
					currentLeft = col + 1;
				}
			}
			
			//compute right (from right to left)
			for(int col = numberOfColumns - 1; col >= 0; col--) {
				if(matrix[row][col] == '1')
					right[col] = Math.min(right[col], currentRight);
				else {
					right[col] = numberOfColumns;
					currentRight = col;
				}
			}
			
			//compute the area of rectangle (can do this from either side)
			for(int col = 0; col < numberOfColumns; col++) {
				maxArea = Math.max(maxArea, (right[col] - left[col]) * height[col]);
			}
		}
		
		return maxArea;
	}

	public static void main(String[] args) {
		char[][] matrix = {
				{'1','0','1','0','0'},
				{'1','0','1','1','1'},
				{'1','1','1','1','1'},
				{'1','0','0','1','0'}	
		};
		
		System.out.println("Maximum Area of Rectangle = " + getMaximalRectangle(matrix));
	}

}
