package string_questions;

/*
 * Time Complexity: O(M+N), where M and N are the lengths of S and T respectively.
 * Space Complexity: O(1).
 */

/*
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a 
 * backspace character.
 * Note that after backspacing an empty text, the text will continue empty.
 * 
 * Example 1:
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * 
 * Example 2:
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * 
 * Example 3:
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * 
 * Example 4:
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * 
 * Note:
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 */

public class BackSpaceStringCompare {

    public static boolean backspaceCompare(String S, String T) {
        return processedString(S).equals(processedString(T));
    }
    
    public static String processedString(String S){
        //Start from the end of string as the name suggests.
        //keep a count of '#'. The confusion is that we don't know when it will come and how many
        //times it will come which will lead to deletion of characters.
        //So only start appending characters from back when the '#' counter is zero. Else skip
        //the character.
        int rightIndex = S.length() - 1;
        int poundKeyCounter = 0;
        StringBuilder sb = new StringBuilder();
        
        while(rightIndex >= 0){
            char ch = S.charAt(rightIndex);
            
            if(ch == '#'){
                poundKeyCounter++;
            } else {
                if(poundKeyCounter != 0)
                    poundKeyCounter--; //skip the character, which is like deleting it.
                else
                    sb.append(ch);
            }
            rightIndex--;
        }
        
        return sb.toString();
    }
    
	public static void main(String[] args) {
		String S = "ab##";
		String T = "c#d#";
		
		System.out.println(backspaceCompare(S, T));
	}

}
