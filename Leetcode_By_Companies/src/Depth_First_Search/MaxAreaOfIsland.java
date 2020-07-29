package Depth_First_Search;

/*
 * Time complexity : O(M × N) where M is the number of rows and N is the number of columns.
 * Space complexity : worst case O(M × N) in case that the grid map is filled with lands where DFS goes by
 * M × N deep.
 */

/*
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 
 * 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * 
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 * 
 * Example 1:
 * {{0,0,1,0,0,0,0,1,0,0,0,0,0},
 *  {0,0,0,0,0,0,0,1,1,1,0,0,0},
 *  {0,1,1,0,1,0,0,0,0,0,0,0,0},
 *  {0,1,0,0,1,1,0,0,1,0,1,0,0},
 *  {0,1,0,0,1,1,0,0,1,1,1,0,0},
 *  {0,0,0,0,0,0,0,0,0,0,1,0,0},
 *  {0,0,0,0,0,0,0,1,1,1,0,0,0},
 *  {0,0,0,0,0,0,0,1,1,0,0,0,0}}
 *  
 *  Given the above grid, return 6. Note the answer is not 11, because the island must be connected 
 *  4-directionally.
 *  
 *  Example 2:
 *  {{0,0,0,0,0,0,0,0}}
 *  
 *  Given the above grid, return 0.
 *  Note: The length of each dimension in the given grid does not exceed 50.
 */

public class MaxAreaOfIsland {

    public static int maxAreaOfIsland(int[][] grid) {
        //edge case
        if(grid == null || grid.length == 0)
            return 0;
        
        int maxArea = 0;
        
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1){
                    maxArea = Math.max(maxArea, dfs(row, col, grid));
                }
            }
        }
        return maxArea;
    }
    
    public static int dfs(int row, int col, int[][] grid){
        //recursion edge case
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || 
           grid[row][col] == 0)
            return 0;
        
        grid[row][col] = 0; //marked as visited
        
        return 1 + dfs(row - 1, col, grid) 
        		 + dfs(row + 1, col, grid) 
        		 + dfs(row, col - 1, grid)
        		 + dfs(row, col + 1, grid);
    }
	
	public static void main(String[] args) {
		int[][] grid = {
					{0,0,1,0,0,0,0,1,0,0,0,0,0},
					{0,0,0,0,0,0,0,1,1,1,0,0,0},
					{0,1,1,0,1,0,0,0,0,0,0,0,0},
					{0,1,0,0,1,1,0,0,1,0,1,0,0},
					{0,1,0,0,1,1,0,0,1,1,1,0,0},
					{0,0,0,0,0,0,0,0,0,0,1,0,0},
					{0,0,0,0,0,0,0,1,1,1,0,0,0},
					{0,0,0,0,0,0,0,1,1,0,0,0,0}
				 };
		
		System.out.println("Max Area of Island = " + maxAreaOfIsland(grid));
	}

}
