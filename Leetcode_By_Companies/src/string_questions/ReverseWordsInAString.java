package string_questions;

/*
 * Time complexity: O(N).
 * Space complexity: O(N).
 */

/*
 * Given an input string, reverse the string word by word.
 * 
 * Example 1:
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * 
 * Example 2:
 * Input: "  hello world!  "
 * Output: "world! hello"
 * 
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * 
 * Example 3:
 * Input: "a good   example"
 * Output: "example good a"
 * 
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 * 
 * Note:
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain 
 * leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 */

public class ReverseWordsInAString {

	public static String reverseWords(String s) {
        //edge case
        if(s == null || s.length() == 0)
            return s;
        
        //removing leading and trailing spaces
        s = s.trim();
        
        //replacing mulitple whitespaces with single whitespace
        s = s.replaceAll("\\s+", " ");
        
        //string to char array, string immutability
        char[] chArr = s.toCharArray();
        
        //Reversing the entire String
        reverse(chArr, 0, chArr.length - 1);
        
        int start = 0;
        int end = 0;
        
        //reverse each word one by one
        while(end < chArr.length){
            while(end < chArr.length && chArr[end] != ' '){
                end++;
            }
            
            //last word condition
            if(end == chArr.length)
                break;
            
            //words other than last word.
            reverse(chArr, start, end - 1);
            
            end = end + 1; //next char after whitespace
            start = end;
        }
        
        reverse(chArr, start, end - 1);
        
        return new String(chArr);
    }
    
    public static void reverse(char[] chArr, int left, int right){
        while(left < right){
            char temp = chArr[left];
            chArr[left] = chArr[right];
            chArr[right] = temp;
            left++;
            right--;
        }
    }
	
	public static void main(String[] args) {
		String str = " the sky is blue   ";
		
		System.out.println("Reversed Word String = " + reverseWords(str));
	}

}
