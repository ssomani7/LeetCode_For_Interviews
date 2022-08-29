package array_questions;

import java.util.Stack;

/*
 * Time Complexity = O(N)
 * Space Complexity = worst case O(N) where our stack will hold all the elements.
 */

/*
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how 
 * many days you would have to wait until a warmer temperature. If there is no future day for which this is 
 * possible, put 0 instead.
 * 
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be 
 * [1, 1, 4, 2, 1, 1, 0, 0].
 * 
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in 
 * the range [30, 100].
 */

public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0)
            return new int[0];
        
        int[] resultArr = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>(); //indices will be held here
        
        for(int index = temperatures.length - 1; index >= 0; index--){
        	//As we are coming from right to left, our stack at the top will be having the next greater
        	//nearest temperature with respect to the current array element.
        	//If our current array element is greater than equal to the stack top temperature, we look in the
        	//stack below for the next greater temperature.
        	//We keep on doing this till we find our temperature or the stack is not empty.
        	//We then push the current element in the stack as our next warm temperature candidate.
            while(!stack.isEmpty() && temperatures[index] >= temperatures[stack.peek()])
                stack.pop();
            
            resultArr[index] = stack.isEmpty() ? 0 : stack.peek() - index;
            
            stack.push(index);
        }
        
        return resultArr;
    }
	
	public static void main(String[] args) {
		int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
		
		int[] resultArr = dailyTemperatures(temperatures);
		
		for(int i : resultArr)
			System.out.print(i + " ");
	}

}
