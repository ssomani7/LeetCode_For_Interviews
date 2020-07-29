package leetcode_hard_questions;

import java.util.Stack;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(n)
 */

/*
 * Implement a basic calculator to evaluate a simple expression string. The expression string may contain open
 * ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * 
 * Example 1:
 * Input: "1 + 1"
 * Output: 2
 * 
 * Example 2:
 * Input: " 2-1 + 2 "
 * Output: 3
 * 
 * Example 3:
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 */

/*
 * Principle:
 * (Sign before '+'/'-') = (This context sign);
 * (Sign after '+'/'-') = (This context sign) * (1 or -1);
 * 
 * Algorithm:
 * Start from +1 sign and scan s from left to right;
 * if c == digit: This number = Last digit * 10 + This digit;
 * if c == '+': Add num to result before this sign; This sign = Last context sign * 1; clear num;
 * if c == '-': Add num to result before this sign; This sign = Last context sign * -1; clear num;
 * if c == '(': Push this context sign to stack;
 * if c == ')': Pop this context and we come back to last context;
 * Add the last num. This is because we only add number after '+' / '-'.
 */

public class BasicCalculator {

	public static int calculate(String str) {
		//edge case
		if(str == null || str.length() == 0)
			return 0;
		
		int result = 0;
		int sign = 1;
		int num = 0;
		Stack<Integer> signStack = new Stack<>();
		signStack.push(sign);
		
		for(int index = 0; index  < str.length(); index++) {
			char ch = str.charAt(index);
			//case 1 : Number. Single or Multiple digit
			if(ch >= '0' && ch <= '9')
				num = num * 10 + ch - '0';
			else if(ch == '+' || ch == '-') {
				result += num * sign;
				//update the sign from previous context
				sign = signStack.peek() * (ch == '+' ? 1 : -1);
				num = 0;
			} else if (ch == '(')
				signStack.push(sign);
			else if(ch == ')')
				signStack.pop();
		}
		
		result += num * sign;
		return result;
	}
	
	public static void main(String[] args) {
		String str = "(1+(4+5+2)-3)+(6+8)";
		//Output: 23
		
		System.out.println("Result = " + calculate(str));
	}

}
