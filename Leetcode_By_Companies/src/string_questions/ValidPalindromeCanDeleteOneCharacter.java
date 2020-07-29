package string_questions;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */

/*
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a 
 * palindrome.
 * 
 * Example 1:
 * Input: "aba"
 * Output: True
 * 
 * Example 2:
 * Input: "abca"
 * Output: True
 * 
 * Explanation: You could delete the character 'c'.
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */

public class ValidPalindromeCanDeleteOneCharacter {

	public static boolean validPalindrome(String s) {
        //edge case
        if(s == null || s.length() == 0)
            return true;
        
        int leftPtr = 0;
        int rightPtr = s.length() - 1;
        
        while(leftPtr <= rightPtr){
            if(s.charAt(leftPtr) != s.charAt(rightPtr)){
                //we can delete the character at either leftPtr or either at rightPtr. So run two Palindrome
                //checks for these 2 strings.
                return isPalindrome(s, leftPtr + 1, rightPtr) || isPalindrome(s, leftPtr, rightPtr - 1);
            }
            leftPtr++;
            rightPtr--;
        }
        
        return true;
    }
    
    public static boolean isPalindrome(String s, int leftPtr, int rightPtr){
        while(leftPtr <= rightPtr){
            if(s.charAt(leftPtr) != s.charAt(rightPtr))
                return false;
            
            leftPtr++;
            rightPtr--;
        }
        return true;
    }
	
	public static void main(String[] args) {
		String s = "abca";
//		String s = "aba";
//		String s = "abcda";
		
		System.out.println("Palindrome formed after deleting one character = " + validPalindrome(s));
	}

}
