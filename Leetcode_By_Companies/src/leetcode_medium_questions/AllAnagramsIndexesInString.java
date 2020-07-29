package leetcode_medium_questions;
/*
 * Time Complexity: O(Ns + Np) since it's one pass along both strings.
 * Space Complexity: O(1), because 'binaryFormOfP' and 'targetFrequency' does not contain more than 26 elements 
 */

/*
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s. Strings consists
 * of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * Example 1:
 * Input:
 * s: "cbaebabacd" p: "abc"
 * 
 * Output:
 * [0, 6]
 * 
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * 
 * Example 2:
 * Input:
 * s: "abab" p: "ab"
 * 
 * Output:
 * [0, 1, 2]
 * 
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllAnagramsIndexesInString {

	public static List<Integer> findAnagrams(String s, String p) {
		 //edge case
        if(s == null || s.length() == 0)
            new ArrayList<Integer>();
        
        List<Integer> resultList = new ArrayList<>();
        int[] targetFrequency = new int[26];
        
        for(int i = 0; i < p.length(); i++){
            targetFrequency[p.charAt(i) - 'a']++;
        }
        
        String binaryFormOfP = Arrays.toString(targetFrequency);
        
        int startIndex = 0;
        int endIndex = startIndex + p.length() - 1;
        
        int searchLength = s.length();
        int[] searchFrequency;
        
        while(endIndex < searchLength){
            searchFrequency = new int[26];
            
            for(int i = startIndex; i <= endIndex; i++){
                searchFrequency[s.charAt(i) - 'a']++;
            }
            
            String windowSearch = Arrays.toString(searchFrequency);
            
            if(windowSearch.equals(binaryFormOfP)){
                resultList.add(startIndex);
            }
            startIndex++;
            endIndex = startIndex + p.length() - 1;    
        }
        return resultList;
    }
	
	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		
		List<Integer> result = findAnagrams(s, p);
		
		for(Integer i : result)
			System.out.print(i + " ");
	}

}
