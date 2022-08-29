package leetcode_easy_questions;

//Time Complexity = O(n)
//Space Complexity = O(1)

/*
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */

/*
 * Example 1:
 * 
 * Input: "III"
 * Output: 3
 * Example 2:
 * 
 * Input: "IV"
 * Output: 4
 * Example 3:
 * 
 * Input: "IX"
 * Output: 9
 * Example 4:
 * 
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * 
 * Example 5:
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */

public class RomanToInteger {

	public static int romanToInt(String s) {
        //edge case
        if(s == null || s.length() == 0)
            return 0;
        
        //Algorithm
        //loop till last 2nd element
        //'i' less than 'i + 1', then sum -= i;
        //'i' greater than equal to 'i + 1' then sum += i
        //always add the last element in the sum.
        
        int sum = 0;
        
        for(int i = 0; i < s.length() - 1; i++){
            char firstCharacter = s.charAt(i);
            char secondCharacter = s.charAt(i + 1);
            
            if(romanMapping(firstCharacter) < romanMapping(secondCharacter))
                sum -= romanMapping(firstCharacter);
            else
                sum += romanMapping(firstCharacter);
        }
        
        sum += romanMapping(s.charAt(s.length() - 1));
        return sum;
    }
    
    public static int romanMapping(char ch){
        int value = 0;
        
        switch(ch){
            case 'I':
                value = 1;
                break;
            case 'V':
                value = 5;
                break;
            case 'X':
                value = 10;
                break;
            case 'L':
                value = 50;
                break;
            case 'C':
                value = 100;
                break;
            case 'D':
                value = 500;
                break;
            case 'M':
                value = 1000;
                break;
        }
        return value;
    }
	
	public static void main(String[] args) {
		String s = "MCMXCIV";
		
		System.out.println("Roman " + s + " to Integer = " + romanToInt(s));
	}

}
