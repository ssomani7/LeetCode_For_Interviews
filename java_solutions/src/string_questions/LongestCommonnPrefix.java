package string_questions;

/*
 * Time Complexity = O(M) for building the Trie, where M is the length of the first word. We then check every
 * other word in the String array (except the first word) at max to 'M' characters in them. If the word is 
 * smaller then our first word on which trie is built, the search terminates even earlier.
 * 
 * Worst Case Time Complexity = O(M), M is the length of each word in the String array is same. So we end up 
 * checking each word in the array till the end.
 * 
 * Space Complexity = O(M), where M is the length of the first word in the String array.
 */

/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1: Input: ["flower","flow","flight"]
 * Output: "fl"
 * 
 * Example 2: Input: ["dog","racecar","car"]
 * Output: ""
 * 
 * Explanation: There is no common prefix among the input strings.
 * 
 * Note: All given inputs are in lowercase letters a-z.
 */

class MyTrieNode {
    boolean endOfWord;
    MyTrieNode[] children = new MyTrieNode[26];

    MyTrieNode(){
        //empty constructor
    }
}

public class LongestCommonnPrefix {

    static MyTrieNode root = new MyTrieNode();
    
    public static void buildTrie(String firstWord){
        if(firstWord == null || firstWord.length() == 0)
            return;
        
        MyTrieNode trieNode = root;
        
        for(int i = 0; i < firstWord.length(); i++){
            char ch = firstWord.charAt(i);
            
            //if no entry in root, create one
            if(trieNode.children[ch - 'a'] == null)
                trieNode.children[ch - 'a'] = new MyTrieNode();
            
            //move down one level in Trie
            trieNode = trieNode.children[ch - 'a'];
        }
        
        trieNode.endOfWord = true; //marks the end of our word. Not needed here. Just kept it for any
        //further follow up questions.
    }
    
    public static String longestCommonPrefix(String[] strs) {
        //edge cases
        if(strs == null || strs.length == 0)
            return "";
        
        if(strs.length == 1)
            return strs[0];
        
        buildTrie(strs[0]); //only need 1 word in our trie
		
        //We will assume that our answer is the first word length. As we go ahead, we will keep taking the 
        //minimum of the common patterns and make it as our result.
        
        String result = strs[0]; //initial state of our result
        
        for(int i = 1; i < strs.length; i++){
            StringBuilder sb = new StringBuilder();
            MyTrieNode trieNode = root; //get the access from root
            
            String word = strs[i];
            
            for(int index = 0; index < word.length(); index++){
                char ch = word.charAt(index);
                
                if(trieNode.children[ch - 'a'] != null){
                    sb.append(ch);
					
                    //move down the trie
                    trieNode = trieNode.children[ch - 'a'];
                } else {
                    //Even if there is a single word in our input which doesn't match with other words,
                    //we need to stop the check for further words and return.
                    if(index == 0)
                        return "";
                    
                    break; //single mismatch also terminates the condition
                }
            }
            
            if(result.length() <= sb.length())
                continue;
            else
                result = sb.toString();
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		String[] strs = {"flower","flow","flight"};
		
		System.out.println(longestCommonPrefix(strs));
	}
}
