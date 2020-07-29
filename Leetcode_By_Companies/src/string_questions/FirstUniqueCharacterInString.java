package string_questions;

import java.util.HashMap;
import java.util.Map;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(n)
 */

/*
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, 
 * return -1.
 * 
 * Examples:
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode",
 * return 2.
 * 
 * Note: You may assume the string contain only lowercase English letters.
 */

public class FirstUniqueCharacterInString {

    public static int firstUniqChar(String s) {
        //edge case
        if(s == null || s.length() == 0)
            return -1;
        
        Map<Character, Integer> charFreqMap = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++)
            charFreqMap.put(s.charAt(i), charFreqMap.getOrDefault(s.charAt(i), 0) + 1);
        
        //Important step. Walk over string and look in hashmap
        for(int i = 0; i < s.length(); i++){
            if(charFreqMap.get(s.charAt(i)) == 1)
                return i;
        }
        
        return -1;
    }
	
	public static void main(String[] args) {
		String s = "loveleetcode";
		
		System.out.println("First Unique Character at = " + firstUniqChar(s));
	}

}
