package dynammic_programming;

/*
 * Time Complexity = O(M x N)
 * Space Complexity = O(M x N)
 */

/*
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the 
 * bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * 
 * How many possible unique paths are there?
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * 
 * Example 1:
 * Input: m = 3, n = 2
 * Output: 3
 * 
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * 
 * Example 2:
 * Input: m = 7, n = 3
 * Output: 28
 * 
 * Constraints:
 * 1 <= m, n <= 100
 * It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9.
 */

public class UniquePaths {

	public static int robotUniquePath(int m, int n) {
        //Dynammic Programming. We will try to reach from star to robot
        //Bottom - up. So we would be allowed to move only left and up.
		
        //So if you see from the Robot's initial perspective for all the cells directly below it
        //you can only come up. And for all the cells right next to it in a straight line, you can only
        //come from right to left.
		
        //So mark all the cells from the robot's initial position as 1 which have either row = 0 or 
        //column = 0. This represents that there is only 1 unique path.
		
        //Rest of the columns will be the sum of its left cell + top cell.
        //In this fashion when we reach the last cell, we will have the total unique paths.
        
        int[][] matrix = new int[m][n];
        
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(row == 0 || col == 0){
                    matrix[row][col] = 1;
                } else {
                    matrix[row][col] = matrix[row][col - 1] + matrix[row - 1][col];
                }
            }
        }
        
        return matrix[m - 1][n - 1];
	}
	
	public static void main(String[] args) {
		int m = 7;
		int n = 3;
		System.out.println(robotUniquePath(m, n));
	}

}
