package matrix_questions;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Time Complexity: O(N), where N is the size of the grid. First, we scan the grid to find the initial values 
 * for the queue, which would take O(N) time.
 * 
 * Then we run the BFS process on the queue, which in the worst case would enumerate all the cells in the grid 
 * once and only once. Therefore, it takes O(N) time.
 * 
 * Thus combining the above two steps, the overall time complexity would be O(N) + O(N) = O(N)
 * 
 * Space Complexity: O(N), where N is the size of the grid.
 * In the worst case, the grid is filled with rotten oranges. As a result, the queue would be initialized with
 * all the cells in the grid.
 * By the way, normally for BFS, the main space complexity lies in the process rather than the initialization. 
 * For instance, for a BFS traversal in a tree, at any given moment, the queue would hold no more than 2 
 * levels of tree nodes. Therefore, the space complexity of BFS traversal in a tree would depend on the width 
 * of the input tree.
 */

/*
 * In a given grid, each cell can have one of three values:
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 * 
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is 
 * impossible, return -1 instead.
 * 
 * Example 1:
 * Input: [
 *         [2,1,1],
 *         [1,1,0],
 *         [0,1,1]
 *        ]
 * Output: 4
 * 
 * Example 2:
 * Input: [
 *         [2,1,1],
 *         [0,1,1],
 *         [1,0,1]
 *        ]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only 
 * happens 4-directionally.
 * 
 * Example 3:
 * Input: [
 *         [0,2]
 *        ]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 * 
 * Note:
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] is only 0, 1, or 2.
 */

public class RottenOranges {

	public static int orangesRotting(int[][] grid) {
        //BFS approach
        
        //edge case
        if(grid == null || grid.length == 0)
            return 0;
        
        int numberOfRows = grid.length;
        int numberOfColumns = grid[0].length;
        int timestamp = 0;
        int countFresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{1,0}, {-1, 0}, {0,1}, {0, -1}};
        //{1,0} -> down, {-1, 0} -> up, {0,1} -> right, {0, -1} -> left
        
        //to begin, add rotten oranges to the queue and count the number of fresh oranges.
        for(int row = 0; row < numberOfRows; row++){
            for(int col = 0; col < numberOfColumns; col++){
                if(grid[row][col] == 2)
                    queue.offer(new int[] {row, col});
                else if(grid[row][col] == 1)
                    countFresh++;
            }
        }
        
        //if there are no fresh oranges then return 0;
        if(countFresh == 0)
            return 0;
        
        while(!queue.isEmpty()){
            timestamp++;
            int qSize = queue.size();
            
            for(int i = 0; i < qSize; i++){
                int[] point = queue.poll();
                
                //check for the 4 directions
                for(int[] direction : directions){
                    int x = point[0] + direction[0];
                    int y = point[1] + direction[1];
                    
                    //check for out of bounds, rotten oranges and empty cell exit
                    if(x < 0 || y < 0 || x >= numberOfRows || y >= numberOfColumns || 
                       grid[x][y] == 2 || grid[x][y] == 0)
                        continue;
                    
                    //this means we are at a grid point where the orange is fresh and can be rotten
                    grid[x][y] = 2;
                    //reduce the fresh orange count
                    countFresh--;
                    //add the new rotten orange to the queue for the next level
                    queue.offer(new int[]{x, y});
                }
            }
        }
        
        return countFresh == 0 ? timestamp - 1 : -1;
    }
	
	public static void main(String[] args) {
		int[][] grid = {
		                 {2,1,1},
		                 {1,1,0},
		                 {0,1,1}
		                };
		System.out.println("Time Required to Rott Oranges = " + orangesRotting(grid));
	}

}
