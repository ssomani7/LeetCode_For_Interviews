package string_questions;

/*
 * Time Complexity = O(N)
 * Space Complexity = O(1)
 */

/*
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * 
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * 
 * Example 1:
 * Input: "USA"
 * Output: True
 * 
 * Example 2:
 * Input: "FlaG"
 * Output: False
 */

public class DetectCapital {

	/*
	 * There are 3 success condition with regards to the count of upper case letters.
	 * All the characters are lower case then the upper case count == 0
	 * All the characters are upper case then the upper case count == word.length()
	 * First character is upper case and else everything is lower case. Then the upper case count == 1
	 */
	
    public static boolean detectCapitalUse(String word) {
        //edge case
        if(word == null || word.length() == 0)
            return false;
        
        int uppercaseCount = 0;
        int firstChar = word.charAt(0);
        
        for(int i = 1; i < word.length(); i++)
            if(word.charAt(i) >= 65 && word.charAt(i) <= 90)
                uppercaseCount++;
        
        if(firstChar >= 65 && firstChar <= 90){
            //remaining should return either 0 or word.length() - 1;
            if(uppercaseCount == word.length() - 1 || uppercaseCount == 0)
                return true;
            else 
                return false;
        } else { //all lowercase, should return uppercaseCount as zero
            return uppercaseCount == 0 ? true : false;
        }
    }
	
	public static void main(String[] args) {
		String word = "Leetcode";
//		String word = "USA";
//		String word = "geeks";
		System.out.println(detectCapitalUse(word));
	}

}
