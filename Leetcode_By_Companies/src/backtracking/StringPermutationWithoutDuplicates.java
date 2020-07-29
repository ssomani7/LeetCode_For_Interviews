package backtracking;

/* Worst Case Time & Space Complexities, when the String does not contains any duplicate characters.
 * 
* Time Complexity = O(n x n!), where 'n' is the length of the String. So to print the one permutation we need
* to go down the 'n' depths in the tree. And there are 'n!' permutations available. So n x n!
* 
* Space Complexity = O(n x n!), because our recursion stack will go upto 'n' levels deep. And since we are
* dealing with Strings, which are immutable objects, there are 'n!' possible answers.
*/ 

public class StringPermutationWithoutDuplicates {

	// Returns true if str[curr] does not matches with any of the characters after str[start]  
	public static boolean shouldSwap(String str, int start, int curr) {
		char[] charArr = str.toCharArray();
		
        for (int i = start; i < curr; i++) { 
            if (charArr[i] == charArr[curr]) { 
                return false; 
            } 
        }
        
        return true; 
	} 
	
	public static void permute(String str, int startIndex, int endIndex) {
		if(startIndex == endIndex)
			System.out.println(str);
		else {
			
			for(int i = startIndex; i <= endIndex; i++) {
				// Proceed further for str[i] only if it doesn't match with any of the characters after 
				//str[startIndex].
				boolean check = shouldSwap(str, startIndex, i);
				
				if(check) {
					str = swap(str, startIndex, i); //finding the permutation
					permute(str, startIndex + 1, endIndex);
					str = swap(str, startIndex, i);//backtracking to initial state, so that we can find permutation
					//for next character.
				}
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
		String str = "ABA";
		permute(str, 0, str.length() - 1);
	}
}
