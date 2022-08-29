package leetcode_medium_questions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * Time Complexity = O(N ^ 2)
 * Space Complexity = O(N)
 */

/*
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if 
 * s can be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * 
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * 
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * 
 * Note that you are allowed to reuse a dictionary word.
 * 
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */

public class WordBreak {

	public static boolean wordBreakMethod(String str, Set<String> dict) {
//		Use a queue of LinkedList to store the indexes from str which will mark the beginning of a new word.
		Queue<Integer> queue = new LinkedList<Integer>();
//		now add the first index of str into the queue.
		queue.offer(0);
//		we will also declare a Set to keep track of visited indexes.
		Set<Integer> visited = new HashSet<Integer>();
		visited.add(0);
		
//		we are going to use the substring method of String class, so 'i' need to be +1 index as the end index is
//		excluded from the substring.
		while(!queue.isEmpty()) {
			int startingIndex = queue.poll();
			for(int i = startingIndex + 1; i <= str.length(); i++) {
//				'visited' set helps us differentiate if the starting index of a new word has already been covered
//				in any previously found word. If yes, we don't need to take the starting index of this word into
//				account, because this starting index is already part of a word that has occured previously and which
//				should be given priority.
//				ex: 'catsandog', the starting index of the word 'sand' i.e 's' is already being covered in the word
//				'cats', so we should check from the next index which in this case is 'a'.
				if(visited.contains(i))
					continue;
				
				if(dict.contains(str.substring(startingIndex, i))) {
					if(i == str.length())
						return true;//means we have found all the words from str in dict.
					queue.offer(i);//adding to the queue the next possible starting index of the word.
					visited.add(i);
				}
			}//end for
		}//end while
		return false;
	}//end wordBreakMethod
	
	public static void main(String[] args) {		
//		String str = "catsandog";
//		Set<String> dict = new HashSet<>();
//		dict.add("cats");
//		dict.add("sand");
//		dict.add("and");
//		dict.add("cat");
//		dict.add("dog");
		
		String str = "applepenapple";
		Set<String> dict = new HashSet<>();
		dict.add("apple");
		dict.add("pen");
		
		boolean result = wordBreakMethod(str, dict);
		System.out.println("Word Break = " + result);
	}

}
