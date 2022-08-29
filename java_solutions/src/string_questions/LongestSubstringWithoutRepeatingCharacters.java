package string_questions;

//Time Complexity = O(n)
//Space Complexity = O(n) worst case, if the String contains all the unique characters then HashSet will be of
//size of 'n'. 'n' = length of String.

import java.util.Set;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
	
	//Use this algorithm when you need to find the shortest unique substring as well.
	//This algorithm basically outputs the substring length which contains all the unique characters.

	public int longestSubstringLengthUnique(String str) {
		if(str.length() == 0 || str == null)
			return 0;
		//solution using window algorithm
		int maxLength = 0;
		int rightPtr = 0;
		int leftPtr = 0;
		Set<Character> hset = new HashSet<>();
		
		while(rightPtr < str.length()) {
			if(hset.add(str.charAt(rightPtr))) { //only possible when there isn't any entry existing in the hashset.
				//or the duplicate entry in the hashset has been removed by the leftPtr.
				//Move the rightPtr, expanding our window.
				rightPtr++;
				//since the window is increased, compute maxLength
				maxLength = Math.max(maxLength, rightPtr - leftPtr);
			} else { //we have encountered a duplicate element
				//remove the first occurence of the duplicate element from the set.
				//This will go on until 'leftPtr' is at the index immediate right to the first occurence of the 
				//duplicate element. So all the elements before the duplicate value is encountered with the 'leftPtr'
				//will also get removed.
				hset.remove(str.charAt(leftPtr));
				//move the leftPtr to the right as our window is changed now.
				leftPtr++;
			}
		}//end while
			
		return maxLength;
	}
	
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
		String s1 = "anviaj";
//		String s4 = "nitish";
//		String s2 = "dvdf";
//		String s3 = "bbbbbb";
		
		int answer = obj.longestSubstringLengthUnique(s1);
		
		System.out.println("answer = " + answer);
	}//end main

}//end class
