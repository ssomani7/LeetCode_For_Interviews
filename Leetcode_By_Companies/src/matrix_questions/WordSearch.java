package matrix_questions;

/*
 * Given a 2D board and a word, find if the word exists in the grid. The word can be constructed from letters of 
 * sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same 
 * letter cell may not be used more than once.
 * 
 * Example:
 * board = 
 * [
 * 	['A','B','C','E'],
 * 	['S','F','C','S'],
 *  ['A','D','E','E']
 * ]
 * 
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * 
 * Constraints:
 * board and word consists only of lowercase and uppercase English letters.
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */

/*
 * Time Complexity = time is O(M * N * 4^L) where M*N is the size of the board and we have 4^L for each cell 
 * because of the recursion.
 * 
 * Space Complexity = O(L), where L is the length of the word to be searched.
 */
public class WordSearch {

	private static boolean[][] visited;
	
	public static boolean exist(char[][] board, String word) {
	
		//the 'visited' boolean array will help us avoid recursing the same start state in the recursion, when we
		//advance to the deeper level from the starting point. Saving us '1' excessive recursion call.
		visited = new boolean[board.length][board[0].length];
		
		
		//We are looping over the 2D array row-wise.
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[row].length; col++) { //board[row] in case matrix NOT 'NxN'
				//word.charAt(0) ennsures that our 'DFS' only begins when we encounter the starting word.
				if((word.charAt(0) == board[row][col]) && search(row, col, 0, board, word))
					return true;
			}
		}
		return false;
	}
	
	public static boolean search(int row, int col, int index, char[][] board, String word) {
		//success condition. index == word.length(), because we enter into 'DFS' recursion with 'index + 1'.
		//And we only go deep into the recursion if we are getting matches with word indices. So only if the
		//'word' is found in the 2D matrix, we will go past index of word and that is our success condition.
		if(index == word.length())
			return true;
		
		//Out of bounds condition
		if(row < 0 || col < 0 || row >= board.length || col >= board[row].length ||
				word.charAt(index) != board[row][col] || visited[row][col])
			return false;
		
		visited[row][col] = true; //Means we have seen a match for 1st time. We mark visited as 'true' so that when
		//we come across same position because of inner recursion, we are aware that this was the starting point of
		//the recursion and we should not go beyond this point.
		
		//4-way recursion now
		if(search(row - 1, col, index + 1, board, word) ||
		   search(row + 1, col, index + 1, board, word) ||
		   search(row, col - 1, index + 1, board, word) ||
		   search(row, col + 1, index + 1, board, word))
			return true;
		
		visited[row][col] = false; //this means we didn't succeed in our 'DFS' recursion search. We started the 
		//search but it failed after start. So getting the visited section to 'false' as the states might be
		//correct for another starting ahead in the matrix.
		//'visited' is maintained globally, so need to bring back states to 'false' after each unsuccessful iteration.
		return false;
	}
	
	public static void main(String[] args) {
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		String word = "SEE";
//		String word = "SEEP"; //output = false
		
		System.out.println("Board contains the word = " + exist(board, word));
	}

}
