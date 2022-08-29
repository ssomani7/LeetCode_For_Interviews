package string_questions;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(1), constant space used by 'compressionIndex'
 */

/*
 * Given an array of characters, compress it in-place. The length after compression must always be smaller than or
 * equal to the original array.
 * 
 * Every element of the array should be a character (not int) of length 1. After you are done modifying the input
 * array in-place, return the new length of the array.
 * 
 * Example 1:
 * Input:["a","a","b","b","c","c","c"]
 * Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * Explanation: "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 * 
 * Example 2:
 * Input:["a"]
 * Output: Return 1, and the first 1 characters of the input array should be: ["a"] 
 * Explanation: Nothing is replaced.
 * 
 * Example 3:
 * Input: ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 * Explanation: Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
 * Notice each digit has it's own entry in the array.
 */

public class StringCompression {

	public static int compress(char[] chars) {
        //edge case
        if(chars.length == 0 || chars == null)
            return 0;
        
        int compressionIndex = 0;
        int i = 0;
        int searchLength = chars.length;
        
        while(i < searchLength){
            int frequency = 0;
            char currentChar = chars[i];
            
            while(i < searchLength && chars[i] == currentChar){
                frequency++;
                i++;
            }
            
            //locating the starting index for character to be written along with its integer count
            chars[compressionIndex] = currentChar;
            //now increment the compressionIndex so that we can start writting the frequency of it.
            compressionIndex++;
            
            //Only need to mention the frequency if it is greater than 1.
            if(frequency != 1){
                //need to conver the count to String from and write one by one value in the chars array
                //Ex: int 12 convert to "12", and then we write "1","2"
                String frequencyOfCharacter = String.valueOf(frequency);
                for(int ch = 0; ch < frequencyOfCharacter.length(); ch++){
                    chars[compressionIndex] = frequencyOfCharacter.charAt(ch);
                    compressionIndex++;
                }
            }
        }
        return compressionIndex;
    }
	
	public static void main(String[] args) {
		char[] chars = {'a','a','b','b','c','c','c'};
		
		System.out.println("Compressed Length of String = " + compress(chars));
		
		for(char ch : chars)
			System.out.print(ch + " ");
	}

}
