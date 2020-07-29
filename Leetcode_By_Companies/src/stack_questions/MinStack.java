package stack_questions;

import java.util.Stack;

/*
 * Let 'n' be the total number of operations performed.
 * Time Complexity : O(1) for all operations.
 * Space Complexity : O(n).
 */

/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * Example 1:
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 
 * Output
 * [null,null,null,null,-3,null,0,-2]
 * 
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 */

public class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    
    public void push(int x) {
        // only push the old minimum value when the current minimum value changes after pushing the new value x
        if(x <= min){          
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop "twice" and "change the current minimum value to the last minimum value".
        if(stack.pop() == min) //stack.pop() will happen even if the 'if' loop is false. Acting as our 'else'
        	min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
