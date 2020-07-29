package Companies.Dunzo;

/*
 * Time Complexity = O(N ^ 2) for building hashmap with 'expandAroundCenter' algorithm. O(K!) for the
 * permutation on the size of the list of values for starting index Zero.
 * 
 * Space Complexity = O(N) for hashmap, all keys are stored. While permutating we only store 1 set of answer
 * which is of 3 strings (palindromic substrings), hence it is a constant space.
 */

/*
 * Three Palindromic Substrings
 * Given an input string word, split the string into exactly three non-empty palindromic substrings and 
 * return them. A string is called a palindrome if it reads the same forward and backward.
 * 
 * For example, abcba, a, and abba are palindromes, while abab and cd are not.
 * 
 * A substring of another string can be obtained from the original string by dropping 0 or more characters 
 * from the beginning, the end, or both ends. For example, the substrings of abc = [abc, ab, bc, a, b, c].
 * 
 * A substring is a palindromic substring if the substring is a palindrome. Working from left to right, 
 * choose the smallest split for the first item that still allows the remaining word to be split into 2 
 * palindromes. Similarly, choose the smallest second palindromic substring that leaves a third palindromic 
 * substring.
 * 
 * Return the substrings in that order. If there is no way to split the word into exactly three palindromic 
 * substrings, return an array that contains a single string: Impossible.
 * 
 * Example
 * word = "kayakracecartenet" This string it can be split into kayak, racecar and tenet. Note that the 
 * smallest split that still leaves two more palindromes is kayak and the next palindrome is racecar.
 * 
 * The return array is [kayak", "racecar", "tenet"].
 * 
 * word = "aardvark" There is no way to split it into three palindromic substrings.
 * The return array is ["Impossible"]

/*
 * Complete the 'threePalindromicSubstrings' function below.
 *
 * The function is expected to return a STRING_ARRAY.
 * The function accepts STRING word as parameter.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreePalindromicSubstrings {

	static List<String> expectedResult = new ArrayList<>();
	
	public static List<String> threePalindromeSubstrings(String word) {
		List<String> result = new ArrayList<>();
		
		//edge case
		if(word == null || word.length() <= 2)
			return result;
			
		//Key is the 'startingIndex' of the palindrome and values are all possible ending indices for that
		//startingIndex which will result into a palindrome.
		Map<Integer, List<Integer>> indexStartEndMap = new HashMap<>();
		
		//build hashmap
		for(int i = 0; i < word.length(); i++) 
			expandAroundCenter(word, i, i, indexStartEndMap);
				
		backtrack(0, result, word, indexStartEndMap);
		
		return result;
	}
	
	public static void backtrack(int startIndexOfPalindromeSubstring, List<String> result, String word, 
								 Map<Integer, List<Integer>> indexStartEndMap) {
		
			//success end condition
			if(result.size() == 3) {
				StringBuilder sb = new StringBuilder();	
				
				for(String str : result)
					sb.append(str);
				
				//Our HashMap is built in such a way that, the first answer that we get among all the other
				//possible answers is our final result. So we don't need to add other possible answer to our
				//final result. Consider the case "aaaaa" where expected result is [a, a, aaa], but you can
				//also achieve [a, aaa, a] or [aaa, a, a] and many other permutations.
				//If you want to get all the possible permutations, just remove the '&& expectedResult.size()'
				//from the below 'if' loop.
				if(sb.toString().equals(word) && expectedResult.size() == 0) {
					for(String str : result)
						expectedResult.add(str);
					return;
				} else //It means our 3 palindromic substrings are not what we wanted.
					return;
			}
			
			//Hoping to avoid other permutation calculations which are not of our interest.
			if(expectedResult.size() != 0)
				return;
			
			//code when result size is != 3
			List<Integer> candidateIndices = indexStartEndMap.get(startIndexOfPalindromeSubstring);
			
			if(candidateIndices != null) { //Came to know about this after debugging for "aaaaa"
				//This happens when the entire string is a substring. So your new starting Index will be
				//word.length(), which is not available in the "indexStartEndMap" map.
				//Since HashMap allows one NULL KEY-VALUE pair, our 'candidateIndices' will be having value NULL
				//And if we try to loop over the NULL value, we get NULL pointer exception.
				//So when we come across that case, we don't need to backtrack.
				for(int  i = 0; i < candidateIndices.size(); i++) {
					int endIndexOfPalindromeSubstring = candidateIndices.get(i);
					result.add(word.substring(startIndexOfPalindromeSubstring, endIndexOfPalindromeSubstring + 1));
					//recurse here
					backtrack(endIndexOfPalindromeSubstring + 1, result, word, indexStartEndMap);			
					//remove the last unsuccessful substring
					result.remove(result.size() - 1);
				}
			}
	}
	
	public static void expandAroundCenter(String word, int left, int right, 
										  Map<Integer, List<Integer>> indexStartEndMap) {
		
		while(left >= 0 && right < word.length() && (word.charAt(left) == word.charAt(right))) {
			//check if left (start) already exists in the map. If yes, just append the new right to its value
			//or make new entry in the map
			List<Integer> endIndexOfPalindromeList = indexStartEndMap.getOrDefault(left, new ArrayList<Integer>());
			endIndexOfPalindromeList.add(right);
			indexStartEndMap.put(left, endIndexOfPalindromeList);
			
			left--;
			right++;
		}
	}
	
    public static void main(String[] args) {
//        String word = "kayakracecartenet";
//        String word = "aardvark";
    	String word = "aaaaa";
//        String word = "";
    	      	
        //This method returns an empty list, because we use the list 'result' inside this method as a buffer
        //to look past different states in backtracking. And we keep removing items from this buffer.
        //So at the end we don't have anything in this buffer.
        
        //Our actual solution is in the global list 'allPossibleAnswers'. But the answer needed as per the
        //question (1st smallest, 2nd smallest, 3rd smallest) can be found in the first 3 strings itself.
        threePalindromeSubstrings(word);
      
    	List<String> result = new ArrayList<>();
    	
        if(expectedResult.size() == 0)
        	result.add("Impossible");
         else 
        	for(String str : expectedResult)
        		result.add(str);
        
        for(String str : result)
        	System.out.print(str + " ");
    }
    
}
