package matrix_questions;

/*
 * Time Complexity = O(m+n)
 * Space Complexity = O(1)
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following 
 * properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * Example:
 * Consider the following matrix:
 *[
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 *]
 *Given target = 5, return true.
 *Given target = 20, return false.
 */

public class SearchInteger {

    public static boolean searchMatrix(int[][] matrix, int target) {
        //edge case check
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return false;
        
        //start search from top-right corner.
        int col = matrix[0].length - 1; //start of last column
        int row = 0; //first row
        
        /*
         * We start search the matrix from top right corner, initialize the current position to top right corner, 
         * if the target is greater than the value in current position, then the target can not be in entire row of
         * current position because the row is sorted. 
         * 
         * If the target is less than the value in current position, then the target can not in the entire column 
         * because the column is sorted too. 
         * 
         * We can rule out one row or one column each time, so the time complexity is O(m+n).
         */
        
        while(row < matrix.length && col >= 0){
            if(target < matrix[row][col]){
                col--; //search on left
            } else if(target > matrix[row][col]){
                row++; //search deeper
            } else
                return true;
        }
        return false;
    }
    
	public static void main(String[] args) {
		int[][] matrix = {
				  {1,   4,  7, 11, 15},
				  {2,   5,  8, 12, 19},
				  {3,   6,  9, 16, 22},
				  {10, 13, 14, 17, 24},
				  {18, 21, 23, 26, 30}
		};
		int target = 14;
		
		System.out.println("target searched successfully in matrix = " + searchMatrix(matrix, target));
	}

}
