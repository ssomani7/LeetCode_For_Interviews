package stack_questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * Time complexity : O(n) because we simply traverse the given string one character at a time and push and pop 
 * operations on a stack take O(1) time.
 * 
 * Space complexity : O(n) as we push all opening brackets onto the stack and in the worst case, we will end 
 * up pushing all the brackets onto the stack. e.g. ((((((((((.
 */

public class ValidParenthesisWithExternalCharacters {

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
            
            //Discard any character other than brackets.
            if(!bracketMap.containsKey(ch) || bracketMap.get(')') != ch || bracketMap.get(']') != ch
            		|| bracketMap.get('}') != ch)
            	continue;
            
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
		String s = "[1, {3}, {4, (2 * (4 * 2) / 3)}]";
		System.out.println(isValid(s));
	}

}
