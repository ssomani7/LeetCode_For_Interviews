package union_find_questions;

/*
 * Note: Prefer DFS approach for this question. It is fast. This is just for knowledge.
 * 
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


/*
 * For Union Find Solution
 * 
 * Time Complexity =  Quick Union + Path Compression is N + MLogN, where N is number of items in a 
 * grid (= rowscolumns) and M - number find-union operations. Which means for us that the time complexity is 
 * O(rowscolumns + Mlog(rowscolumns)).
 * 
 * Space complexity: O(width * height of the array)
 */
class UnionFind {

    private int[] parents;
    private int[] rank;
    private int num;

    public UnionFind(int N) {
        num = N;
        parents = new int[N];
        for (int i = 0; i < N; i++) 
        	parents[i] = i; //initially parents[] will have values same as index, simulating the head component.
        rank = new int[N]; //initially rank[] will be empty. All values will be Zero.
    }

    public int find(int i) {
        return (parents[i] == i) ? i : find(parents[i]);
    }

    public boolean union(int i, int j) {
        int pi = find(i); 
        int pj = find(j);
        
        if (pi == pj) 
        	return false;
        if (rank[pi] > rank[pj]) 
        	parents[pj] = pi;
        else {
            parents[pi] = pj;
            if (rank[pi] == rank[pj]) 
            	rank[pj]++;
        }
        num--;
        return true;
    }

    public int size() {
        return num; //marks the connected elements
    }
}

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid.length == 0) 
        	return 0;
        
        int number_of_rows = grid.length;
        int number_of_columns = grid[0].length;
        int zeros = 0;
        
        UnionFind uf = new UnionFind(number_of_rows * number_of_columns);
        int[][] distance = {
        		{0,1}, 
        		{1,0}
        };
        
        for (int row = 0; row < number_of_rows; row++) {
            for (int col = 0; col < number_of_columns; col++) {
                if (grid[row][col] == '0') {
                	zeros++; 
                	continue; 
                }
                for (int[] d : distance) {
                	//We look for consecutive '1' from our current position forward [row][col + 1] and we look
                	//downward [row + 1][col]. If we get '1' there only then we do Union.
                	//For this forward and downward, we keep distance array of [0,1] for forward and [1,0] for
                	//downward.
                    int x = row + d[0];
                    int y = col + d[1];
                    if (x >= 0 && x < number_of_rows && y >= 0 && y < number_of_columns && grid[x][y] == '1') {
                        uf.union(row * number_of_columns + col, x * number_of_columns + y);
                    }
                }
            }
        }
        
        return uf.size() - zeros;
    }
	
	public static void main(String[] args) {
		char[][] grid = {
				{'1','1','0','0'},
				{'0','0','1','0'},
				{'0','0','0','1'}
		};
		
		NumberOfIslands obj = new NumberOfIslands();
		
		System.out.println(obj.numIslands(grid));
	}

}
