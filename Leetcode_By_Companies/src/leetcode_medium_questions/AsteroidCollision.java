package leetcode_medium_questions;

/*
 * Time Complexity: O(N), where N is the number of asteroids. Our stack pushes and pops each asteroid at most
 * once.
 * Space Complexity: O(N), the size of outputArr.
 */

/*
 * We are given an array asteroids of integers representing asteroids in a row. For each asteroid, the absolute
 * value represents its size, and the sign represents its direction (positive meaning right, negative meaning
 * left). Each asteroid moves at the same speed.
 * 
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will 
 * explode. If both are the same size, both will explode. Two asteroids moving in the same direction will 
 * never meet.
 * 
 * Example 1:
 * Input: 
 * asteroids = [5, 10, -5]
 * Output: [5, 10]
 * Explanation: 
 * The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
 * 
 * Example 2:
 * Input: 
 * asteroids = [8, -8]
 * Output: []
 * Explanation: 
 * The 8 and -8 collide exploding each other.
 * 
 * Example 3:
 * Input: 
 * asteroids = [10, 2, -5]
 * Output: [10]
 * Explanation: 
 * The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.
 * 
 * Example 4:
 * Input: 
 * asteroids = [-2, -1, 1, 2]
 * Output: [-2, -1, 1, 2]
 * Explanation: 
 * The -2 and -1 are moving left, while the 1 and 2 are moving right.
 * Asteroids moving the same direction never meet, so no asteroids will meet each other.
 * 
 * Note:
 * The length of asteroids will be at most 10000.
 * Each asteroid will be a non-zero integer in the range [-1000, 1000]..
 */

import java.util.Stack;

public class AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {
    	Stack<Integer> stack = new Stack<>();
    	
    	for(int i = 0; i < asteroids.length; i++) {
    		if(stack.isEmpty() || asteroids[i] > 0)
    			stack.push(asteroids[i]);
    		else { //collision case : stack top is +ve and asteroids[i] is -ve
    			while(true) {
    				int stackTop = stack.peek();
    				
    				if(stackTop < 0) {
    					stack.push(asteroids[i]);
    					break;
    				} else if(stackTop == -asteroids[i]) { //stack top +ve & asteroids[i] is -ve, Both are EQUAL
    					//Destroy both the elements, at top of stack and asteroids[i] (skip it)
    					stack.pop();
    					break;
    				} else if (stackTop > -asteroids[i]) {//Stack top +ve > -ve asteroids[i], destroy asteroids[i[
    					break;
    				} else { //stack top +ve but smaller than -ve asteroids[i], destroy stack top
    					stack.pop();
    					if(stack.isEmpty()) { //stack had all +ve, but the -ve asteroids[i] was bigger than all
    						stack.push(asteroids[i]);
    						break;
    					}
    				}
    			}
    		}
    	}
    	
    	int[] outputArr = new int[stack.size()];
    	
    	for(int i = stack.size() - 1; i >=0; i--)
    		outputArr[i] = stack.pop();
    	
    	return outputArr;
    }
	
	public static void main(String[] args) {
		int[] asteroids = {10, 2, -15, 5};
		
		int[] result = asteroidCollision(asteroids);
		
		for(int i : result)
			System.out.print(i + " ");
	}

}
