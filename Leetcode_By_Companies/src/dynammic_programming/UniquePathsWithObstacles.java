package dynammic_programming;

/*
 * Time Complexity = O(M x N)
 * Space Complexity = O(M)
 */

/*
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the 
 * bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * Note: m and n will be at most 100.
 * 
 * Example 1:
 * Input:
 * [
 *  [0,0,0],
 *  [0,1,0],
 *  [0,0,0]
 * ]
 * 
 * Output: 2
 * 
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 */

public class UniquePathsWithObstacles {

	public static int numberOfUniquePathsWithObstacles(int[][] obstacleGrid) {
        //Dynammic Programming
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        
        //We will walk over the matrix row wise. Our dp array will indicate the number of unique ways
        //that are possible to reach that particular cell from the start.
        
        //Since we can only move either right or down, all the cells in the first row and first column
        //will have the max value of 1, given there is no obstacle. Hence we don't do any processing when
        //we are at cell which is either in the first row or first column.
        
        //Whenever we come across an obstacle, we simply mark that cell as zero, because there is no way
        //we can choose that cell as a path to reach our destination.
        for(int[] row : obstacleGrid){
            for(int cell = 0; cell < width; cell++){
                if(row[cell] == 1) //obstacle
                    dp[cell] = 0;
                else if (cell > 0) //our dp array is updated row level wise
                    dp[cell] += dp[cell - 1];
            }
        }
        
        return dp[width - 1];
	}
	
	public static void main(String[] args) {
		int[][] obstacleGrid = {
				{0, 0, 0},
				{0, 1, 0},
				{0, 0, 0}
		};
		
		System.out.println(numberOfUniquePathsWithObstacles(obstacleGrid));
	}

}
