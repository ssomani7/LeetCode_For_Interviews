package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * Time Complexity : O(4^n / sqrt(n)). Each valid sequence has at most n steps during the backtracking 
 * procedure.
 * 
 * Space Complexity : O(4^n / sqrt(n)) as described above, and using O(n) space to store the sequence.
 */

/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */

public class GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        
        backtrack(resultList, "", 0, 0, n);
        
        return resultList;
    }
    
    public static void backtrack(List<String> resultList, String str, int open, int close, int max){
        //ending condition. We assign given 'n' to max and if you observe carefully all the possible
        //combination Strings are twice the length of max. So that is our ending codition
        if(str.length() == max * 2){
            resultList.add(str);
            return;
        }
        
        if(open < max)
            backtrack(resultList, str + "(", open + 1, close, max);
        
        if(close < open)
            backtrack(resultList, str + ")", open, close + 1, max);
    }
	
	public static void main(String[] args) {
		int n = 3;
		
		List<String> result = generateParenthesis(n);
		
		for(String str : result)
			System.out.println(str);
	}

}
