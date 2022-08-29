package string_questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Time Complexity: O(P+B), where P is the size of paragraph and B is the size of banned.
 * Space Complexity: O(P+B), to store the count and the banned set.
 */

/*
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of 
 * banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is 
 * unique.
 * 
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph 
 * are not case sensitive.  The answer is in lowercase.
 * 
 * Example:
 * Input: 
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * 
 * banned = ["hit"]
 * 
 * Output: "ball"
 * 
 * Explanation: 
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
 * Note that words in the paragraph are not case sensitive, that punctuation is ignored (even if adjacent to 
 * words, such as "ball,"), and that "hit" isn't the answer even though it occurs more because it is banned.
 */

public class MostCommonWord {

    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> wordCountMap = new HashMap<>();
        
        //4 steps:
        //Step 1 = remove all punctuations
        //Step 2 = change to lowercase
        //Step 3 = words count for each word not in banned set
        //Step  4 = return the most common word
        
        //"\\W+" indicates a word character, equivalent to [a-zA-Z_0-9]. Special characters don't match.
        //It cuts the string as soon as it encounters a character other than alphabet or 0 to 9 number and
        //replaces all the special characters with " " (whitespace).
        //"\\s+" matches one or more whitespaces.
        String[] words = paragraph.replaceAll("\\W+" , " ").toLowerCase().split("\\s+");//Important Regex
        
        for(String word : words){
            if(!bannedSet.contains(word))
                wordCountMap.put(word, wordCountMap.getOrDefault(word , 0) + 1);
        }
        
        int max = 0;
        
        for(Map.Entry<String, Integer> entry : wordCountMap.entrySet())
            if(entry.getValue() > max)
                max = entry.getValue();
        
        for(Map.Entry<String, Integer> entry : wordCountMap.entrySet())
            if(entry.getValue() == max)
                return entry.getKey();
        
        return ""; //default
    }
	
	public static void main(String[] args) {
		String paragraph = "Bob hit$$ a ***bALl, the hit %%%BALL flew far after it was hit.";
		String[] banned = {"hit"};
		
		String result = mostCommonWord(paragraph, banned);
		System.out.println("Most Common Word = " + result);
	}

}
