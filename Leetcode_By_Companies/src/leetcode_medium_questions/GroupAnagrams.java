package leetcode_medium_questions;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
/*
 * Time Complexity: O(N x K), where 'N' is the length of 'strs' array, and 'K' is the maximum length of a string in 
 * strs. Counting each string is linear in the size of the string, and we count every string.
 * 
 * Space Complexity: O(N x K), the total information content stored in hashmap.
 */

/*
 * Given an array of strings, group anagrams together.
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * Output:
 * [
 *  ["ate","eat","tea"],
 *  ["nat","tan"],
 *  ["bat"]
 * ]
 * 
 * Note:
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagrams {

	public static List<List<String>> groupAnagrams(String[] strArray){
		/*
		 * Anagrams are basically 2 strings that have same frequency of characters in them. They are just out of
		 * positions.
		 * 
		 * So we can form a uniform key of all the anagrams in an int[] of size 26 which represents the alphabets.
		 * Each index in this array points to the frequency of that character in the word.
		 * 
		 * So, its like representing a string in Binary String form.
		 * Ex: abczzyyy & zyzcbyya are anagrams. They both can be represented as 11100000000000000000000032
		 * 
		 * We will use this Binary String as a key and use a LinkedList to store all the values against the key.
		 * So in this fashion our hashmap key will correspond to a particular group of anagrams.
		 */
		
		//edge case
		if(strArray.length == 0 || strArray == null)
			return null; 
		
		Map<String, List<String>> anagramMap = new HashMap<>();
		
		for(String currentStr : strArray) {
			int[] alphabetFrequency = new int[26];
			
			for(int i = 0; i < currentStr.length(); i++) {
				alphabetFrequency[currentStr.charAt(i) - 'a']++; //'c' - 'a' = 2, array index from 0 to 25
			}
			
			String binaryFormOfCurrentStr = Arrays.toString(alphabetFrequency);
			//check if there is an existing key for the binary form in the hashmap. If so, simply add to the
			//linkedlist of the value;
			List<String> tempList = anagramMap.getOrDefault(binaryFormOfCurrentStr, new LinkedList<String>());
			//add the currentStr to the value section.
			tempList.add(currentStr);
			//Now update the hashmap by putting in the new updated LinkedList.
			anagramMap.put(binaryFormOfCurrentStr, tempList);
		}
		
		return new LinkedList<>(anagramMap.values());
	}
	public static void main(String[] args) {
		String[] strArray = {"eat", "tea", "tan", "ate", "nat", "bat"};
	
		List<List<String>> anagramList = groupAnagrams(strArray);
		
		for(List<String> list : anagramList)
			System.out.println(list);
	}

}
