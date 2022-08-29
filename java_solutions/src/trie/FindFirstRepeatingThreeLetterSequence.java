package trie;

/* m = Denotes the window size.
 * 
 * "Insert"
 * Time complexity : O(m), where m is the key/word length. In each iteration of the algorithm, we either examine or
 * create a node in the trie till we reach the end of the key/word. This takes only 'm' operations.
 * 
 * Space complexity : O(m). In the worst case newly inserted key doesn't share a prefix with the the keys already
 * inserted in the trie. We have to add 'm' new nodes, which takes us O(m) space.
 */

/*
 * "Search"
 * Time complexity : O(m) In each step of the algorithm we search for the next key character. In the worst case the
 * algorithm performs m operations.
 * 
 * Space complexity : O(1)
 */

/*
 * For 10 GB of stream of lower case alphabets, and 240 MB RAM, write a program to find the first repeating 3 
 * letter sequence.
 * “fnjdkbgjdfbgfdkbnfkdnf…........…”, “dkb” is the first repeating sequence.
 */

/*
 * class TrieNode{
	boolean isWord; //deafult is false
	TrieNode[] children = new TrieNode[26];
	
	TrieNode() {
		//empty constructor
	}
}
 */

public class FindFirstRepeatingThreeLetterSequence {

	private static TrieNode root;
	
	public FindFirstRepeatingThreeLetterSequence() {
		root = new TrieNode(); //initialized with children[26] of nulls and isWord of false;
	}
	
	public static void insert(String word) {
		TrieNode nodePtr = root; //capture the root/head
		
		for(int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			
			//doesn't exists, make a new object
			if(nodePtr.children[ch - 'a'] == null)
				nodePtr.children[ch - 'a'] = new TrieNode();
			//move down the tree of the existing object or newly created object
			nodePtr = nodePtr.children[ch - 'a'];
		}
		nodePtr.isWord = true;
	}
	
	public static String search(String word) {
		TrieNode nodePtr = root; //capture the root/head
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			
			//doesn't exists, return false
			if(nodePtr.children[ch - 'a'] == null)
				return sb.toString();
			//move down the tree, only possible if sub tree exists.
			nodePtr = nodePtr.children[ch - 'a'];
			sb.append(ch);
		}
		return sb.toString();
	}
	
	public static String buildTrie(String str, int window) {
		//edge case
		if(str.length() < window)
			return "";
		
		str = str.toLowerCase(); //make the pattern lowercase, or else create a Trie of 128 or 256 depending 
		//on your assumption of characters in the string. If the range of characters is guranteed to be between
		//0 to 127 or 0 to 255, then directly use the character value as the index respectively on the TrieNode
		//array you declare. The changes will occure in the 'insert' and 'search' method, where you will directly
		//use the character value as index instead of subtracting it from 'a'.
		
		//build the initial trie for first window.
		insert(str.substring(0, window));
		
		//now loop over the string and see if the pattern matches
		for(int index = window; index < str.length(); index++) {
			String result = search(str.substring(index - (window - 1), index + 1));
			
			if(result.length() == window)
				return result;
			else
				insert(str.substring(index - (window - 1), index + 1));
		}
		
		return ""; //default
	}
	
	public static void main(String[] args) {
		String str = "fnjdkbgjdfbgfdkbnfkdnf";
		FindFirstRepeatingThreeLetterSequence obj = new FindFirstRepeatingThreeLetterSequence();
		
		System.out.println(buildTrie(str, 3));
	}

}
