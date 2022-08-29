package string_questions;

/*
 * Time complexity: O((N−L)L) in the worst case of numerous almost complete false matches, and O(N) in the best
 * case of one single match.
 * 
 * Space complexity: O(1).
 */

/*
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * 
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * 
 * Clarification:
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's 
 * strstr() and Java's indexOf().
 */

public class ImplementStrStr {

    public static int strStr(String haystack, String needle) {
        if(needle.length() == 0) //needle is empty
            return 0;
         
         if(haystack.length() < needle.length())
             return -1;
         
         for(int i = 0; i <= haystack.length() - needle.length(); i++){
             int searchPtr = 0;
             while(searchPtr < needle.length()){
                 if(haystack.charAt(i + searchPtr) != needle.charAt(searchPtr)){
                    break; 
                 }
                 searchPtr++;
             }
             
             if(searchPtr == needle.length())
                 return i;
         }
         
         return -1;
     }
	
	public static void main(String[] args) {
		String haystack = "hello";
		String needle = "ll";
		
		System.out.println("Strstr = " + strStr(haystack, needle));
	}

}
