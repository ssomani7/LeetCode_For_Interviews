package trie;

/*
 * Time Complexity: 
 * addWord() - O(n), n = length of the new word
 * search() - Below are the 2 functionalities
 * Best case = O(n), when there is no dot in the search word.
 * Worst case: O(n + 26^n), n = the total number of characters in the word. 26^n because we need to do 
 * recursion using bactracking when a dot appears.
 * 
 * Space complexity : 
 * addWord() - O(m). In the worst case newly inserted key doesn't share a prefix with the the keys already
 * inserted in the trie. We have to add 'm' new nodes, which takes us O(m) space.
 */

/*
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * 
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . 
 * means it can represent any one letter.
 * 
 * Example:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 */

/*
 * class TrieNode{
 * 	  boolean isWord;
 *    TrieNode[] children = new TrieNode[26];
 *    
 *    TrieNode(){};
 * } 
 */

public class AddAndSearchWord {

	TrieNode root;
	
	AddAndSearchWord(){
		root = new TrieNode();
	}
	
	public void addWord(String word) {
		TrieNode nodePtr = root;
		
		for(int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			
			if(nodePtr.children[ch - 'a'] == null)
				nodePtr.children[ch - 'a'] = new TrieNode();
			
			nodePtr = nodePtr.children[ch - 'a'];
		}
		nodePtr.isWord = true;
	}
	
	public boolean search(String word) {
		char[] wordArr = word.toCharArray();
		return match(wordArr, 0, root);
	}
	
	public boolean match(char[] wordArr, int index, TrieNode nodePtr) {
		//recursion end condition. We are recursing with 'index + 1', so our 'i' in the recursion calls gets
		//incremented.
		if(index == wordArr.length)
			return nodePtr.isWord;
		
		//for any word consiting of '.' anywhere in the word, we have to search for the possiblity of an existing
		//path in the Trie we build. So, we have to check recursively for each possiblity along with the characters
		//next in sequence.
		if(wordArr[index] == '.') {
			//now search the entire children[] at this level and check the next character with recursion. This will
			//help search for the entire word forming the recursive chain.
			for(int i = 0; i < nodePtr.children.length; i++) {
				//only check for the nodes which aren't null, so that they can be considered as a possible replace
				//ment for '.'
				//For each non-null node, we take that as root and start searching downwards along that path.
				if(nodePtr.children[i] != null && match(wordArr, index + 1, nodePtr.children[i])) {
					return true;
				}
			}
		} else {
			//We will check whether the given lowercase alphabet exists in the TrieNode[]. If yes, we select that
			//and start searching downwards
			return nodePtr.children[wordArr[index] - 'a'] != null && 
					match(wordArr, index + 1, nodePtr.children[wordArr[index] - 'a']);
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		AddAndSearchWord obj = new AddAndSearchWord();
		obj.addWord("at");
		obj.addWord("and");
		obj.addWord("an");
		obj.addWord("add");
		
		System.out.println(obj.search("a"));
		System.out.println(obj.search(".at"));
		
		obj.addWord("bat");
		
		System.out.println(obj.search(".at"));
		System.out.println(obj.search("an."));
		System.out.println(obj.search("a.d."));
		System.out.println(obj.search("b."));
		System.out.println(obj.search("a.d"));
		System.out.println(obj.search("."));
	}

}
