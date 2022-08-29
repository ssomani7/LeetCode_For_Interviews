package leetcode_medium_questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Queue;
import java.util.LinkedList;

/*
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
 * sequence from beginWord to endWord, such that:Only one letter can be changed at a time. Each transformed word 
 * must exist in the word list.
 * 
 * Note: Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * Example 1:
 * Input: beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Example 2:
 * Input: beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

/*
 * Time Complexity: O(M×N), where 'M' is the length of words and 'N' is the total number of words in the input word
 * list. Finding out all the transformations takes 'M' iterations for each of the 'N' words. Also, breadth first 
 * search in the worst case might go to each of the 'N' words.
 * 
 * Space Complexity: O(M×N), to store all 'M' transformations for each of the 'N' words. Queue for BFS in worst 
 * case would need space for all 'N' words.
 */

public class WordLadder {

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		//We need to search for the transformed words in constant time, so convert List to Set.
		Set<String> wordSet = new HashSet<>(wordList);
		
		//Edge case check.
		if(!wordSet.contains(endWord))
			return 0;
		
		//We will use a BFS approach. Since we can change only one letter at a time, we will go level by
		//transformation.
		/*
		 * 							hit    ----> 0
		 *  						 |
		 * 							hot    ----> 1
		 *  						 |
		 * 							/ \
		 *						  dot lot  ----> 2
		 *						   |   |
		 *						  dog log  ----> 3
		 *						   |
		 *						  cog      ----> 4
		 * We are returning "level + 1", so our answer is 5, which is correct.
		 */
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		
		int transformationLength = 0;
		
		while(!queue.isEmpty()) {
			//doing level traversal, so record size of queue per level
			int qSize = queue.size();
			
			for(int i = 0; i < qSize; i++) {
				String currentWord = queue.poll();
				
				//check if the currentWord is the target word
				if(currentWord.equals(endWord)) {
					return transformationLength + 1;
				}
				//now we have to check permutations for each place of the string. For each place we will permute
				//from 'a' to 'z'. This goes for all the indices of the String. String immutable in java, cannot
				//be converted to changed. Hence convert to character array first.
				char[] wordArr = currentWord.toCharArray();
				
				for(int index = 0; index < wordArr.length; index++) {
					//Need to store original character, so that the char array can be restored to the original
					//state when permutated for next index.
					char originalValueAtIndexBeforPermutation = wordArr[index];
					for(char permute = 'a'; permute <= 'z'; permute++) {
						wordArr[index] = permute;
						
						//Don't check for the originalCharacter
						if(wordArr[index] == originalValueAtIndexBeforPermutation)
							continue;
						
						String wordAfterPermutation = new String(wordArr);
						//check if the permutated word exists in the wordSet. If yes, add it to the queue because
						//it is an candidate for the next transformation and also remove that word from the wordSet
						//to avoid duplicate candidates.
						if(wordSet.contains(wordAfterPermutation)) {
							queue.add(wordAfterPermutation);
							wordSet.remove(wordAfterPermutation);
						}
					}
					wordArr[index] = originalValueAtIndexBeforPermutation;
				}
			}
			transformationLength++; //this marks that we have completed one level.
		}
		return 0;
	}
	
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("cog");
		
		System.out.println("Transformation Length = " + ladderLength(beginWord, endWord, wordList));
	}

}
