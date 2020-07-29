package leetcode_easy_questions;

/*
 * Time Complexity = O(m x n)
 * Space Complexity = O(1)
 */

/*
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents 
 * water.
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by 
 * water,and there is exactly one island (i.e., one or more connected land cells).
 * 
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One 
 * cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine 
 * the perimeter of the island.
 * 
 * Example:
 * Input:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *  
 *  Output: 16
 *  Explanation: The perimeter is the 16 yellow stripes in the image below:
 *  */

public class IslandPerimeter {

	public static int getIslandPerimeter(int[][] grid) {
		//edge case
		if(grid == null || grid.length == 0)
			return 0;
		
		int perimeter = 0;
		
		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid[0].length; col++) {
				if(grid[row][col] == 1) {
					//left
					if(col == 0 || grid[row][col - 1] == 0)
						perimeter++;
					//up
					if(row == 0 || grid[row - 1][col] == 0)
						perimeter++;
					//right
					if(col == grid[0].length - 1 || grid[row][col + 1] == 0)
						perimeter++;
					//down
					if(row == grid.length - 1 || grid[row + 1][col] == 0)
						perimeter++;
				}
			}
		}
		
		return perimeter; //default
	}
	
	
	public static void main(String[] args) {
		int[][] grid = {{0,1,0,0},
		                {1,1,1,0},
		                {0,1,0,0},
		                {1,1,0,0}};
		System.out.println(getIslandPerimeter(grid));
	}

}
