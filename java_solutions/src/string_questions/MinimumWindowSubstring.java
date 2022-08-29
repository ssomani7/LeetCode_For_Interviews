package string_questions;

/*
 * Time Complexity: O(∣S∣+∣T∣) where |S| and |T| represent the lengths of strings S and T. In the worst case 
 * we might end up visiting every element of string S twice, once by left pointer and once by right pointer. 
 * ∣T∣ represents the length of string T.
 * 
 * Space Complexity: O(∣S∣+∣T∣). ∣S∣ when the window size is equal to the entire string S. ∣T∣ when T has all
 * unique characters. 
 */

/*
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in 
 * complexity O(n).
 * 
 * Example:
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * 
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */

public class MinimumWindowSubstring {

	public static String minWindow(String s, String t) {
        //Sliding window, but the window has to be expanded from 'endPtr' increment and shrinked by incrementing
        //'startPtr'
        if(s.length() < t.length())
            return "";
        
        int[] charFreqArr = new int[128];
        
        for(int i = 0; i < t.length(); i++)
            charFreqArr[t.charAt(i)]++;
        
        int startPtr = 0;
        int endPtr = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int counter = t.length();
        
        while(endPtr < s.length()){
            char ch1 = s.charAt(endPtr);
            //decrease counter only when the value at the charFreqArr is > 0
            if(charFreqArr[ch1] > 0)
                counter--;
            charFreqArr[ch1]--;
            endPtr++;
            
            while(counter == 0){
                if(minLen > endPtr - startPtr){
                    minLen = endPtr - startPtr;
                    minStart = startPtr;
                }
                char ch2 = s.charAt(startPtr);
                charFreqArr[ch2]++;
                //increment the counter only when the value at the charFreqArr > 0, to break from the while loop
                //and start the search again by expanding window from endPtr
                if(charFreqArr[ch2] > 0)
                    counter++;
                startPtr++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
	
	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		
		System.out.println("Minimum Window Substring = " + minWindow(s, t));
	}

}
