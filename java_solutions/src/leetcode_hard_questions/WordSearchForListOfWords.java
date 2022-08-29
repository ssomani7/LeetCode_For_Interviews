package leetcode_hard_questions;

import java.util.ArrayList;
import java.util.List;

/*
 * Time complexity: O( M ( 4 x 3 ^ L−1)), where M is the number of cells in the board and LL is the 
 * maximum length of words.
 * 
 * It is tricky is calculate the exact number of steps that a backtracking algorithm would perform. We 
 * provide a upper bound of steps for the worst scenario for this problem. The algorithm loops over all the 
 * cells in the board, therefore we have MM as a factor in the complexity formula. It then boils down to the 
 * maximum number of steps we would need for each starting cell (i.e. 4 x 3 ^ L−1)
 * 
 * Assume the maximum length of word is L, starting from a cell, initially we would have at most 4 
 * directions to explore. Assume each direction is valid (i.e. worst case), during the following exploration, 
 * we have at most 3 neighbor cells (excluding the cell where we come from) to explore. As a result, we would 
 * traverse at most 4 x 3 ^ L−1 cells during the backtracking exploration.
 * 
 * One might wonder what the worst case scenario looks like. Well, here is an example. Imagine, each of the 
 * cells in the board contains the letter a, and the word dictionary contains a single word ['aaaa']. Voila. 
 * This is one of the worst scenarios that the algorithm would encounter.
 * 
 * Note that, the above time complexity is estimated under the assumption that the Trie data structure would 
 * not change once built. If we apply the optimization trick to gradually remove the nodes in Trie, we could 
 * greatly improve the time complexity, since the cost of backtracking would reduced to zero once we match 
 * all the words in the dictionary, i.e. the Trie becomes empty.
 * 
 * Space Complexity: O(N), where N is the total number of letters in the dictionary.
 * 
 * The main space consumed by the algorithm is the Trie data structure we build. In the worst case where 
 * there is no overlapping of prefixes among the words, the Trie would have as many nodes as the letters of 
 * all words. And optionally, one might keep a copy of words in the Trie as well. As a result, we might need 
 * 2N space for the Trie.
 */

/*
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those 
 * horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * 
 * Example:
 * Input: 
 * board = [
 *           ['o','a','a','n'],
 *           ['e','t','a','e'],
 *           ['i','h','k','r'],
 *           ['i','f','l','v']
 *         ]
 *         
 * words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 * 
 * Note:
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 */

public class WordSearchForListOfWords {

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word; //Keep words in the Trie.
        /*
         * One might use a flag in the Trie node to indicate if the path to the current code match any word 
         * in the dictionary. It is not necessary to keep the words in the Trie.
         * 
         * However, doing so could improve the performance of the algorithm a bit. One benefit is that one 
         * would not need to pass the prefix as the parameter in the backtracking() call. And this could 
         * speed up a bit the recursive call. Similarly, one does not need to reconstruct the matched word 
         * from the prefix, if we keep the words in Trie.
         */
    }
    
    public TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        
        for(String str : words){
            TrieNode currentLevel = root;
            
            for(int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);
                
                //If there is no entry at that level in Trie, create one
                if(currentLevel.children[ch - 'a'] == null)
                    currentLevel.children[ch - 'a'] = new TrieNode();
                
                //move down one level in the Trie
                currentLevel = currentLevel.children[ch - 'a'];
            }
            
            currentLevel.word = str; //This signifies the end of the word and we would be able to return the
            //word.
        }
        
        return root;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> resultList = new ArrayList<>();
        TrieNode root = buildTrie(words);
        
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                dfs(board, row, col, root, resultList);
            }
        }
        
        return resultList;
    }
    
    public void dfs(char[][] board, int row, int col, TrieNode root, List<String> resultList){
        char ch = board[row][col];
        
        //visited or non-existent entry in trie
        if(ch == '$' || root.children[ch - 'a'] == null)
            return;
        
        root = root.children[ch - 'a']; //walk down the Trie
        
        //see if we have reached the trie end
        if(root.word != null){
            resultList.add(root.word);
            root.word = null; //Remove the matched words from the Trie.
            /*
             * In the problem, we are asked to return all the matched words, rather than the number of 
             * potential matches. Therefore, once we reach certain Trie node that contains a match of word, 
             * we could simply remove the match from the Trie.
             * 
             * As a side benefit, we do not need to check if there is any duplicate in the result set. As a 
             * result, we could simply use a list instead of set to keep the results, which could speed up 
             * the solution a bit.
             */
        }
        
        board[row][col] = '$'; //mark as visited
        
        if(row > 0)
            dfs(board, row - 1, col, root, resultList); //up
        if(col > 0)
            dfs(board, row, col - 1, root, resultList); //left
        if(row < board.length - 1)
            dfs(board, row + 1, col, root, resultList); //down
        if(col < board[0].length - 1)
            dfs(board, row, col + 1, root, resultList); //right
        
        //restore the board for other words searches
        board[row][col] = ch;
    }
	
	public static void main(String[] args) {
		char[][] board = {
				{'o','a','a','n'},
				{'e','t','a','e'},
				{'i','h','k','r'},
				{'i','f','l','v'}
		};
		String[] words = {"oath","pea","eat","rain"};
		
		WordSearchForListOfWords wordSearch2 = new WordSearchForListOfWords();
		
		List<String> resultList = wordSearch2.findWords(board, words);
		
		for(String str : resultList)
			System.out.println(str);
	}

}
