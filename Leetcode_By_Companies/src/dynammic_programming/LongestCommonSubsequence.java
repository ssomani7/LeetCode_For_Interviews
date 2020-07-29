package dynammic_programming;

/*
 * Time complexity : O(M x N). We're solving M x N subproblems. Solving each subproblem is an O(1) operation.
 * Space complexity : O(M x N). We'e allocating a 2D array of size M x N to save the answers to subproblems.
 */

/*
 * Given two strings text1 and text2, return the length of their longest common subsequence. A subsequence of
 * a string is a new string generated from the original string with some characters(can be none) deleted 
 * without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" 
 * while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
 * If there is no common subsequence, return 0.
 * 
 * Example 1:
 * Input: text1 = "abcde", text2 = "ace" 
 * Output: 3  
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * 
 * Example 2:
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * 
 * Example 3:
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 * 
 * Constraints:
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * The input strings consist of lowercase English characters only.
 */

public class LongestCommonSubsequence {

	public static int getLongestCommonSubsequence(String text1, String text2) {
		//Using DP
		int[][] dp = new int[text1.length() + 1][text2.length() + 1];
		
		//Characters will be compared M x N, where M is the length of text1 and N is the length of text2
		//M x N comparison, assume 'i' is the pointer on text1 and 'j' is the pointer on text2 then
		//dp is [i + 1][j + 1].
		//For match, we see dp[i][j] + 1, else we take max of the cells to the left & top.
		
        for(int row = 0; row < text1.length(); row++){
            for(int col = 0; col < text2.length(); col++){
                if(text1.charAt(row) == text2.charAt(col)){
                    dp[row + 1][col + 1] = 1 + dp[row][col];
                } else {
                    dp[row + 1][col + 1] = Math.max(dp[row + 1][col], dp[row][col + 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
	}
	
	public static void main(String[] args) {
		String text1 = "abcde"; 
		String text2 = "ace";
		
		System.out.println("Longest Common Subsequence = " + getLongestCommonSubsequence(text1, text2));
	}
	
}
