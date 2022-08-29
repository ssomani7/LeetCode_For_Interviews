package backtracking;

/*
 * Time Complexity = O(n x n!), where 'n' is the length of the String. So to print the one permutation we need
 * to go down the 'n' depths in the tree. And there are 'n!' permutations available. So n x n!
 * 
 * Space Complexity = O(n x n!), because our recursion stack will go upto 'n' levels deep. And since we are
 * dealing with Strings, which are immutable objects, there are 'n!' possible answers. 
 */

/*
 * Logic: Given String "ABC". At the first level, assume you have the pointer on character zero, that is 'A'
 * So you can swap 'A with A' -> 'ABC', 'A with B' -> 'BAC', 'A with C' -> 'CBA'
 * 							
 *            Level 1       ABC
 *                        /  |  \
 *            Level 2  ABC  BAC  CBA
 *                     
 * Now at Level 2, we fix one character for which we have permuted, i.e, 'A'. So we move our pointer to next
 * character for each string keeping the first character fixed.
 * 
 *            Level 1       ABC
 *                        /  |   \
 *           Level 2  ABC   BAC    CBA
 *                    /\     /\     / \
 *        Level 3  ABC ACB BAC BCA CBA CAB
 *        
 * So from our permutation code, we first code down the left side of tree, ABC -> ABC -> ABC, ACB
 * Now we would like to have to permute for the next character from the root level. So the second swap method
 * takes us back, like ACB -> ABC -> ABC. Now we can move the pointer to 'B' and start swapping from there.
 * 
 * So the first swap method before permutation call is to generate different permutations for a particular
 * character and the second one is to backtrack and return to the root level again and repeat the process for
 * another character.
 */

public class StringPermutationWithDuplicates {

	public static void permute(String str, int startIndex, int endIndex) {
		if(startIndex == endIndex)
			System.out.println(str);
		else {
			for(int i = startIndex; i <= endIndex; i++) {
				str = swap(str, startIndex, i); //finding the permutation
				permute(str, startIndex + 1, endIndex);
				str = swap(str, startIndex, i);//backtracking to initial state, so that we can find permutation
				//for next character.
			}
		}
	}
	
	public static String swap(String str, int i, int j) {
		char[] charArr = str.toCharArray();
		char temp = charArr[i];
		charArr[i] = charArr[j];
		charArr[j] = temp;
		
		return String.valueOf(charArr);
	}
	
	public static void main(String[] args) {
		String str = "ABC";
		permute(str, 0, str.length() - 1);
	}

}
