package backtracking;

import java.util.LinkedList;
import java.util.List;

/*
 * Time complexity : O(3 ^ N × 4 ^ M) where N is the number of digits in the input that maps to 3 letters 
 * (e.g. 2, 3, 4, 5, 6, 8) and M is the number of digits in the input that maps to 4 letters (e.g. 7, 9), and 
 * N + M is the total number digits in the input.
 * 
 * Space complexity : O(3 ^ N × 4 ^ M) since one has to keep (3 ^ N × 4 ^ M) solutions.
 */

public class LetterCombinationsOfPhoneNumber {

//	declare a string array to emulate phone number letters
//	keep '0' and '1' as empty strings to get phone numbers as array indexes
	private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	
    public static List<String> letterCombinations(String digits) {
       List<String> outputList = new LinkedList<String>();
       
       //edge case
       if(digits == null || digits.length() == 0) 
    	   return outputList;
       
       combination("", digits, 0, outputList);
       
       return outputList;
    }
	
    //offset = used as a pointer to iterate over individual characters in the input string, making it treat as
	//		   an array    
    private static void combination(String prefix, String digits, int offset, List<String> outputList) {
    	//boundary condition for recursive function
    	if(offset >= digits.length()) {
    		outputList.add(prefix);
    		return;
    	}
    	
    	//Extracting the index and from that index extracting the words present on String[] KEYS
    	String letters = KEYS[digits.charAt(offset) - '0'];
    	
    	for(int i = 0; i < letters.length(); i++) {
    		combination(prefix + letters.charAt(i), digits, offset + 1, outputList);
    	}
    }
	 
    private static List<String> letterCombinationsBFSUsingFIFO(String digits){
    	LinkedList<String> result = new LinkedList<>();
    	
    	//Edge case
    	if(digits.isEmpty())
    		return result;
    	
    	result.add(""); //empty string, length = 0, 0 ascii is 48
    	
    	//Largest permutation's length will be equal to the number of digits or digits length.
    	//Ex: "23", has 2 digits or length of 2 when treated as a String.
    	while(result.peek().length() != digits.length()) {
    		String atHead = result.remove(); 
    		/*
    		 * will remove and return the element at the head of the LinkedList.
    		 * We are going to use the length of the element at the head to extract the numerical value from
    		 * string 'digits'. So our 'atHead' will act as our offset on the string 'digits'.
    		 * We will use this offset as an index on the KEYS string[] and extract our letter set.
    		 */
	
    		String letters = KEYS[digits.charAt(atHead.length()) - '0'];
    		
    		for(char c : letters.toCharArray()) {
    			result.add(atHead + c); //ex: 'ad', 'ae', 'af', in the next while iteration it will be
    									// 'bd', 'ce', 'cf', and after that 'cd', 'ce', 'cf'.
    		//Now at the head is 'ad', whose length is equal to digits '23', so we are done, hence while loop 
    		//exits.
    		}
    	}//end while
    	
    	return result;
    }//end iterative method
    
	public static void main(String[] args) {
		String digits = "23";
		
		List<String> result = letterCombinations(digits);
		
		for(String str : result) {
			System.out.print(str + " ");
		}
		
		System.out.println();
		
		List<String> result2 = letterCombinationsBFSUsingFIFO(digits);
		
		for(String str : result2) {
			System.out.print(str + " ");
		}
	}

}
