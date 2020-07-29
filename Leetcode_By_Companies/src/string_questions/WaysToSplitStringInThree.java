package string_questions;

import java.util.HashMap;
import java.util.Map;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(n), worst case when all the characters in string are 'a'
 */

/*
 * You are given a string S consisting of letters 'a' and 'b'. You want to split it into three separate 
 * non-empty parts. The lengths of the parts can differ from one another.
 * In how many ways can you split S into three parts, such that each part contains the same number of letters
 * 'a'?
 * 
 * Write a function: that, given a string S of length N which only contains letters 'a' and 'b', returns the
 * number of possible ways of splitting S as described above.
 * 
 * Examples:
 * S = 'babaa' => 2
 * 
 * The splits are:
 * 'ba | ba | a'
 * 'bab | a | a'
 * 
 * S = 'ababa' => 4
 * 
 * The splits are:
 * 'a | ba| ba'
 * 'a | bab | a'
 * 'ab | a | ba'
 * 'ab | ab | a'
 */

public class WaysToSplitStringInThree {

	private static int solve(String s) {
		int count = 0; //total number of a's in the string
		
		for(char c : s.toCharArray()) {
			if(c == 'a')
				count += 1;
			else
				count += 0;
		}
		
		//number of a's is not a multiple of 3
		if(count % 3 != 0)
			return 0;
		
		int k = count / 3;
		int aCount = 0; 
		int res = 0;
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'a')
				aCount += 1;
			else
				aCount += 0;
			
			if(aCount == 2 * k)
				res += map.get(k);
			
			map.put(aCount, map.getOrDefault(aCount, 0) + 1);
		}
		return res;
	}
	
	public static void main(String[] args) {
		String s1 = "babaa"; 
		String s2 = "ababa";
		System.out.println(solve(s1));
		System.out.println(solve(s2));
	}

}
