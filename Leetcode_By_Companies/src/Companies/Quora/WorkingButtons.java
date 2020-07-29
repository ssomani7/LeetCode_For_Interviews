package Companies.Quora;

import java.util.HashSet;
import java.util.Set;

public class WorkingButtons {

	//{ "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		//  0    1   2       3      4      5      6     7       8      9
		
		public static boolean[] workingButtons(int[] digits, String[] words) {
			boolean[] result = new boolean[words.length];
			
			final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
			
			Set<Character> digitSet = new HashSet<>();
			
			//first populate the characters available while looping on digits array
			for(int i : digits) {
				String letters = KEYS[i];
				
				//add it to the hashset
				for(int index = 0; index < letters.length(); index++)
					digitSet.add(letters.charAt(index));
			}//end for loop
			
			for(int i = 0; i < words.length; i++) {
				String word = words[i];
				
				boolean wordCanBeFormed = true;
				
				for(int index = 0; index < word.length(); index++) {
					if(!digitSet.contains(word.charAt(index))) {
						wordCanBeFormed = false;
						break;
					}
				}
				
				result[i] = wordCanBeFormed;	
			}
			
			return result;
		}
		
		
		public static void main(String[] args) {
			int[] digits = {2,3};
			String[] words = {"abc", "gdef"};
			
			boolean[] result = workingButtons(digits, words);
			
			for(boolean flag : result) {
				System.out.print(flag + " ");
			}
		}

}
