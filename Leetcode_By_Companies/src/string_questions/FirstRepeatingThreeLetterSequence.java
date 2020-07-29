package string_questions;

import java.util.HashSet;
import java.util.Set;

/*
 * Time Complexity = O(n), because we are trusting our hash function to be unique. So by using extra space of
 * hashset, if we find a match, we just return the substring.
 * Space Complexity = worst case O(n), where we find the pattern in the end, making our hashset store all the
 * values.
 */

/*
 * For 10 GB of stream of lower case alphabets, and 240 MB RAM, write a program to find the first repeating 3 
 * letter sequence.
 * “fnjdkbgjdfbgfdkbnfkdnf…........…”, “dkb” is the first repeating sequence.
 */

public class FirstRepeatingThreeLetterSequence {

	public static String rollingHash(String str, int window) {
		//edge case
		if(str.length() < window)
			return "";
		
		str = str.toLowerCase();
		int primeNumber = 5381;
		//Alphabets from range 1 to 26. So numbers become base 26
		Set<Integer> sequenceHash = new HashSet<>();
		int powerOfBase = window - 1;
		int myHash = 0;
		
		//calculate the initial hash
		for(int i = 0; i < window; i++) {
			int alphabetValue = (str.charAt(i) - 'a') + 1;
			//important hashing formula
			myHash = (myHash + (alphabetValue * (int)(Math.pow(26, powerOfBase)))) % primeNumber;
			//decrease the powerBase
			powerOfBase--;
		}
		
		//adding the initial hash
		sequenceHash.add(myHash);
		
		//set the power base again to its starting state
		powerOfBase = window - 1;
		
		//now start sliding the window from the next character in string where the first window ended.
		for(int i = window; i < str.length(); i++) {
			//remove the left most character of the older window from the current hash
			int alphabetValue = (str.charAt(i - window) - 'a') + 1;
			myHash = myHash - (alphabetValue * (int)(Math.pow(26, powerOfBase)));
			
			//now left shift the myHash to left by 1 bit with respect to base 26
			myHash = myHash * 26;
			
			//now add the character at 'i' the position to the hash. Here the power of 26 is 0. So just add the
			//character value to the hash.
			myHash = myHash + str.charAt(i) - 'a' + 1;
			
			//check if the hash exists in the set
			if(sequenceHash.contains(myHash)) {
				return str.substring(i - (window - 1), i + 1);
			} else 
				sequenceHash.add(myHash);
		}
		
		return ""; //default
	}
	
	public static void main(String[] args) {
		String str = "fnjdkbgjdfbgfdkbnfkdnf";
		int window = 3;
		System.out.println(rollingHash(str, window));
	}

}
