package leetcode_medium_questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * N = length of input string
 * Time Complexity = O(2 ^ N) for worst case when all the combinations of string are valid. 
 * Ex:  str = aaa, dic=[a, aa, aaa]
 * 
 * Let N be the length of the input string and W be the number of words in the dictionary.
 * Time Complexity: O(N ^ 2 + 2^N + W)
 * 
 * Space Complexity = O(2^N x⋅N + W)
 */

/*
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces 
 * in s to construct a sentence where each word is a valid dictionary word. Return all such possible 
 * sentences.
 * 
 * Note:The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * 
 * Example 1:
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 
 * Example 2:
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * 
 * Example 3:
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 */

public class WordBreak2 {

    public static List<String> wordBreak(String s, List<String> wordDict) {
        //edge case
        if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
            return new ArrayList<String>();
        
        return helper(s, wordDict, new HashMap<String, List<String>>());
    }
    
    //recursive method
    public static List<String> helper(String str, List<String> wordDict, Map<String, List<String>> memoMap){
        //memoMap helps us avoid duplicate processing of the same "str". If our map has that "str"
        //we will simple return the List<String> that str can form
        if(memoMap.containsKey(str))
            return memoMap.get(str);
        
        List<String> resultList = new ArrayList<>();
        
        //base case
        if(str.length() == 0){
            resultList.add("");
            return resultList;
        }
        
        for(String word : wordDict){
            if(str.startsWith(word)){
                //So our recursive method will have a new "str" as input, where the string starts from
                //the character after the first word ended.
                //Ex: str = catsanddog, our word = cat. So, "str" starts with "cat". So our recursive
                //method will have new "str" as "anddog".
                //So, for each recursive method, we will have a new "str"
                String modifiedStr = str.substring(word.length());
                List<String> subset = helper(modifiedStr, wordDict, memoMap);
                
                //Because String is an immutable object, we need to recreate it each and every time we
                //come back from recursion. Hence, we are doing the "for" loop here.
                for(String subWord : subset){
                    //Since we are making our result from right to left, our recursive call will start
                    //returning from an empty list. So that we don't need to have additional space after
                    //the last word in each possible combination.
                    
                    //Ex: for "cats and dog", the string will be built, from right to left.
                    //In this fashion cats <- and <- dog <- "", but starting from right to left.
                    //Recursion will simulate the right to left part.
                    String optionalSpace = subWord.isEmpty() ? "" : " ";
                    resultList.add(word + optionalSpace + subWord);
                }
            }
        }
        
        memoMap.put(str, resultList);
        return resultList;
    }
	
	public static void main(String[] args) {
		String s = "catsanddog";
		List<String> wordDict = new ArrayList<>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		
		List<String> resultList = wordBreak(s, wordDict);
		
		for(String combination : resultList)
			System.out.println(combination);
	}

}

