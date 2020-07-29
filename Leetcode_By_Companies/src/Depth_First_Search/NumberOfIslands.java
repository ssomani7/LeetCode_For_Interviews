package Depth_First_Search;

/*
 * Time complexity : O(M × N) where M is the number of rows and N is the number of columns.
 * Space complexity : worst case O(M × N) in case that the grid map is filled with lands where DFS goes by
 * M × N deep.
 */

/* 
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by
 * water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * Output: 1
 * 
 * Example 2:
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * Output: 3
 */

public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        //edge case
        if(grid == null || grid.length == 0)
            return 0;
        
        int number_of_islands = 0;
        
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == '1'){
                    number_of_islands++;
                    dfs(row, col, grid);
                }
            }
        }
        return number_of_islands;
    }
    
    public static void dfs(int row, int col, char[][] grid){
        //recursion edge case
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || 
           grid[row][col] == '0')
            return;
        
        grid[row][col] = '0'; //marked as visited
        
        dfs(row - 1, col, grid); //up
        dfs(row + 1, col, grid); //down
        dfs(row, col - 1, grid); //left
        dfs(row, col + 1, grid); //right
    }
	
	public static void main(String[] args) {
		char[][] grid = {
				{'1','1','0','0'},
				{'0','0','1','0'},
				{'0','0','0','1'}
		};
		
		System.out.println("Number of Islands by DFS = " + numIslands(grid));
	}

}
