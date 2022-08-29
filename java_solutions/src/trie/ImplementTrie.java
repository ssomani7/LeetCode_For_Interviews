package trie;

/*
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
 * "StartsWith"
 * Time complexity : O(m)
 * Space complexity : O(1)
 */

/*
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Example:
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");   
 * trie.search("app");     // returns true
 * 
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */

class TrieNode{
	boolean isWord; //deafult is false
	TrieNode[] children = new TrieNode[26];
	
	TrieNode() {
		//empty constructor
	}
}

public class ImplementTrie {

	private TrieNode root;
	
	ImplementTrie(){
		root = new TrieNode(); //initialized with children[26] of nulls and isWord of false;
	}
	
	public void insert(String word) {
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
	
	public boolean search(String word) {
		TrieNode nodePtr = root; //capture the root/head
		
		for(int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			
			//doesn't exists, return false
			if(nodePtr.children[ch - 'a'] == null)
				return false;
			//move down the tree, only possible if sub tree exists.
			nodePtr = nodePtr.children[ch - 'a'];
		}
		return nodePtr.isWord; //each level has a boolean value which shows if it is a word.
	}
	
	public boolean startsWith(String prefix) {
		TrieNode nodePtr = root; //capture the root/head
		
		for(int i = 0; i < prefix.length(); i++) {
			char ch = prefix.charAt(i);
			
			if(nodePtr.children[ch - 'a'] == null)
				return false;
			//move down the tree
			nodePtr = nodePtr.children[ch - 'a'];
		}
		return true;
	}
	
	public static void main(String[] args) {
		ImplementTrie obj = new ImplementTrie();
		obj.insert("apple");
		System.out.println(obj.search("apple"));
		System.out.println(obj.search("saurabh"));
		System.out.println(obj.startsWith("app"));
		System.out.println(obj.startsWith("le"));
	}

}
