package string_questions;

/*
 * Time Complexity = O(N), N is the length of String. Both Strings are of equal length
 * Space Complexity = O(1) space, constant array of 256 elements are considered O(1)
 */

/*
 * Given two strings s and t, determine if they are isomorphic. Two strings are isomorphic if the characters 
 * in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of 
 * characters. No two characters may map to the same character but a character may map to itself.
 * 
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 * 
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 * 
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 * 
 * Note:
 * You may assume both s and t have the same length.
 */


/*
 * Trick = Increment the frequency count as the last seen index. both index should be same. This will give the
 * one to one mapping effect for O(n)
 */
public class IsomorphicStrings {

	public static boolean isIsomorphic(String s, String t) {
		/*
		 * We need one to one mapping. So we will declare an array of 256 for each string.
		 * Instead of their frequency, we will store their index values at their respective cells in 2 arrays.
		 * This will simulate the 1 to 1 mapping.
		 * If the values at those respctive character array position don't match, we return false.
		 */
		int[] frequencyArrayForString1 = new int[256];
		int[] frequencyArrayForString2 = new int[256];
		
		for(int index = 0; index < s.length(); index++) {
			if(frequencyArrayForString1[s.charAt(index)] != 
					frequencyArrayForString2[t.charAt(index)])
				return false;
			
			//tricky part. Need to update index + 1 to differentiate between the empty values of the array
			//going forward.
			frequencyArrayForString1[s.charAt(index)] = index + 1;
			frequencyArrayForString2[t.charAt(index)] = index + 1;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		String s = "aba";
		String t = "baa";
		
//		String s = "egg";
//		Stirng t = "add";
//		Output = True
		
		System.out.println("Strings are Isomorphic = " + isIsomorphic(s, t));
	}

}
