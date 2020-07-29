package trie;

import java.util.Arrays;
import java.util.List;


/*
 * Time Complexity = Trie, use the dictionary to build a trie, and match the string, time complexity 
 * O( n * len(d) + len(s) ), len(d) denotes the average length of word in dictionary, and len(s) denotes the 
 * length of string.
 */

/*
 * Given a dictionary of valid words, write a function isTypoBecauseStuckKey() that accepts a string to 
 * determine if the string has a typo that is strictly caused by a stuck key.
 * 
 * Example:
 * Input:
 * Dictionary: { hello, cat, world, dog, bird, grass, green, help, greet, great }
 * String: bbbirrrdddd
 * Output: True
 * 
 * Explanation: The character's 'b', 'r', & 'd' all repeat. Assuming their keys got stuck, we can form the 
 * word 'bird', which exists in the dictionary.
 * 
 * Example:
 * Input:
 * Dictionary: { hello, cat, world, dog, bird, grass, green, help, greet, great }
 * String: gggraasssa
 * Output: False
 * 
 * Explanation: The a at the end is not the result of a stuck key, and thus it is impossible for it to exist 
 * in the dictionary.
 */

/*
 * class TrieNode {
 * 		boolean isWord;
 * 		TrieNode[] children = new TrieNode[26];
 * 
 * 		TrieNode(){
 * 			//empty constructor
 * 		}
 * }
 */

public class StuckKeyWord {

	//global instance of root.
	private TrieNode root;
	
	StuckKeyWord(){
		root = new TrieNode(); //This will be the starting level
	}
	
	public void insert(String word) {
		TrieNode nodePtr = root; //first character needs to be searched at the root level
		
		for(int i = 0; i < word.length(); i++) {
			if(nodePtr.children[word.charAt(i) - 'a'] == null) {
				//No existing element to start the path. So make one.
				nodePtr.children[word.charAt(i) - 'a'] = new TrieNode();
			}
			//now go to deep into the path that you have created or found
			nodePtr = nodePtr.children[word.charAt(i) - 'a'];
		}
		nodePtr.isWord = true; //marks the end of the word
	}
	
	public void createTrie(List<String> dict) {
		for(String word : dict) 
			insert(word);
	}
	
	//recursive method. We look at the root object's children array and pass in the next index for recursion 
	//at each level. We pass 'index + 1' from the beginning because we are always comparing two states of the
	//character for the repeated character. Hence we designed our recurison in such a way that we look at the
	//character of current index and look for the next character and then decide on result.
	public boolean match(TrieNode root, int index, String givenWord) {
		if(root == null)
			return false;
		
		if(index == givenWord.length())
			return root.isWord;
		
		//The character has a path downwards from its current level in the trie
		if(match(root.children[givenWord.charAt(index) - 'a'], index + 1, givenWord))
			return true;
		else if(index > 0 && givenWord.charAt(index) == givenWord.charAt(index - 1)) //skip the current repated char and match the rest
			return match(root, index + 1, givenWord); //See if we find the next char in the current root children array
		else
			return false; //a different character totally which is absent at the root children array level
	}
	
	public  boolean isTypoBecauseStuckKey(List<String> dict, String givenWord){
		//Step 1: create trie
		createTrie(dict);
		//Step 2 : collect the result from recursive method. Root is available as a global variable.
		boolean result = match(root, 0, givenWord);
		return result;
	}
	
	public static void main(String[] args) {
		List<String> dict = Arrays.asList("hello", "cat", "world", "dog", "bird", "grass", "green", "help", 
				 "greet", "great" );
		String givenWord = "hhheeelllllppp";
		StuckKeyWord startObj = new StuckKeyWord(); //TrieNode root has been initialized here with null values
		
		System.out.println("Typo Because of Stuck Key = " + startObj.isTypoBecauseStuckKey(dict, givenWord));
	}

}
