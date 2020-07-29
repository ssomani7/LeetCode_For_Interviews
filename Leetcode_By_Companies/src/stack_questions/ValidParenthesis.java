package stack_questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * Time complexity : O(n) because we simply traverse the given string one character at a time and push and pop 
 * operations on a stack take O(1) time.
 * Space complexity : O(n) as we push all opening brackets onto the stack and in the worst case, we will end 
 * up pushing all the brackets onto the stack. e.g. ((((((((((.
 */

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input 
 * string is valid.
 * 
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * 
 * Example 1:
 * Input: "()"
 * Output: true
 * 
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 * 
 * Example 3:
 * Input: "(]"
 * Output: false
 * 
 * Example 4:
 * Input: "([)]"
 * Output: false
 * 
 * Example 5:
 * Input: "{[]}"
 * Output: true
 */


public class ValidParenthesis {

    public static boolean isValid(String s) {
        //edge case
        if(s == null || s.length() == 0)
            return true;
        
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')','(');
        bracketMap.put(']','[');
        bracketMap.put('}','{');
        
        Stack<Character> stack = new Stack<>();
        
        for(int index = 0; index < s.length(); index++){
            char ch = s.charAt(index);
            
            //Only pop from stack when you come across a closing 'bracket' while iterating String
            if(!stack.isEmpty() && bracketMap.containsKey(ch)){
                //closing bracket match found
                if(stack.peek() == bracketMap.get(ch)){
                    stack.pop();
                    continue;
                } else
                    return false; //misMatch found
            } else {
                //opening bracket is found or any other character is found.
                stack.push(ch);
            }
        }
        
        return stack.isEmpty(); //very important step. Consider case when String s = ')'
    }
	
	public static void main(String[] args) {

	}

}
