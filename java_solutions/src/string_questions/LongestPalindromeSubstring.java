package string_questions;

/*
 * Time complexity : O(n ^ 2). Since expanding a palindrome around its center could take O(n) time, the overall
 * complexity is O(n ^ 2).
 * 
 * Space complexity : O(1). 
 */

/*
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s 
 * is 1000.
 * 
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * 
 * Note: "aba" is also a valid answer.
 * 
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 */

public class LongestPalindromeSubstring {

	public static String longestPalindromeSubstring(String str) {
		int start = 0;
		int end = 0;
		
		for(int center = 0; center < str.length(); center++) {
			int oddLengthPalindrome = expandAroundCenter(str, center, center);
			int evenLengthPalindrome = expandAroundCenter(str, center, center + 1);
			int maxLengthPalindrome = Math.max(oddLengthPalindrome, evenLengthPalindrome);
			
			if(maxLengthPalindrome > end - start) {
//				Since we are expanding around center, the left part of the center, i.e, left half starting point will
//				give us the start. So, subtracting half length from the center. Similarly for the right half just add
//				the half length to the right of center, which will give us the end.
//				"-1" is for extracting the zero index from String "str" for start.
//				for the end we can use the entire length as it is.
				start = center - (maxLengthPalindrome - 1) / 2;
				end = center + maxLengthPalindrome / 2;
			}
		}//end for
		
		return str.substring(start, end + 1);
	}//end longestPalindromeSubstring
	
	public static int expandAroundCenter(String str, int left, int right) {
		int L = left;
		int R = right;
		
		while(L >= 0 && R < str.length() && str.charAt(L) == str.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1; // "-1" to get the nominal length of palindromic substring and not the index based.
	}//end expandAroundCenter
	
	public static void main(String[] args) {
		String str = "babad";
		
		System.out.println("Longest Palindromic Substring = " + longestPalindromeSubstring(str));
	}

}
