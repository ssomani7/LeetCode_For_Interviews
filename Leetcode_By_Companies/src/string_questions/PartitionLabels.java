package string_questions;

import java.util.ArrayList;
import java.util.List;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */

/*
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible 
 * so that each letter appears in at most one part, and return a list of integers representing the size of 
 * these parts.
 * 
 * Example 1:
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 * 
 * Note:
 * S will have length in range [1, 500].
 * S will consist of lowercase letters ('a' to 'z') only.
 */

public class PartitionLabels {

	public static List<Integer> partitionLabels(String str) {
        List<Integer> result = new ArrayList<>();
        
        //edge case
        if(str.length() == 0 || str == null)
            return result;
        
        //Keep an array which will tell us the last index occurence of a character
        int[] lastIndex = new int[26];
        
        for(int i = 0; i < str.length(); i++)
            lastIndex[str.charAt(i) - 'a'] = i;
        
        int start = 0;
        int end = 0;
        
        //now use the substring to detect the length our desired results
        for(int i = 0; i < str.length(); i++){
            //update end with the last index of the character 
            end = Math.max(end, lastIndex[str.charAt(i) - 'a']);
            
            //we have found our window for substring
            if(end == i){
                result.add(end - start + 1); // +1 because we want the length
                //update the start
                start = end + 1;
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		String str = "ababcbacadefegdehijhklij";
		List<Integer> result = partitionLabels(str);
		
		for(Integer i : result)
			System.out.print(i + ", ");
	}

}
