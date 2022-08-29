package leetcode_hard_questions;

/*
 * Time complexity : O(N), since each element is processed exactly twice - it's index added and then removed 
 * from the deque.
 * Space complexity : O(N), since O(N − k + 1) is used for an output array and O(k) for a deque.
 */

/*
 * Deque used such that the Largest element will always be at the head of the queue.
 */

/*
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array 
 * to the very right. You can only see the k numbers in the window. Each time the sliding window moves right
 * by one position. Return the max sliding window.
 * 
 * Follow up:
 * Could you solve it in linear time?
 * 
 * Example:
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7] 
 * Explanation: 
 * 
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int range) {		
    	if(nums.length == 0 || nums == null || range > nums.length)
    		return new int[0];
    	
    	int index = 0;
    	int[] result = new int[nums.length - range + 1];
    	//You can insert & delete from both the ends
    	Deque<Integer> deque = new ArrayDeque<>();
    
    	while(index < nums.length) {
    		/*
    		 * first check if the index of the largest element at the front of the queue is out of window
    		 * Since we are storing the index of the largest element at the Head of the deque, just check if
    		 * it is falling out of the current window.
    		 * 
    		 * Since our window is moving forward, i.e, from left to right and since we are using only 1 ptr,
    		 * to represent the window, we will have to subtract the range from our current ptr, i.e, index
    		 * So, if the index present in the deque head EQUALS iterating index - range, it means our max
    		 * index at head of deque is no longer in the window and we need to remove it.
    		 * 
    		 * Ex: Assume max index = 1, iterating index is at 4, and window size is 3. So, subtracting 3 places
    		 * from 4th index we get a window of [4, 3, 2]. 4 - 3 = 1. Because of array index starting from 0,
    		 * we need to be careful while calculating window.
    		 * 
    		 * Because we are using only 1 ptr for representing the end of the window, window range should be
    		 * calculated from right to left as we move ahead in the array.
    		 */    		
    		if(!deque.isEmpty() && deque.peek() == index - range)
    			deque.pollFirst();
    		
    		/*
    		 * Main use of Deque is that whenever an element is inserted from back, we remove all the existing
    		 * elements in the deque which are smaller than the new element. In this fashion the new element if
    		 * greatest among all moves to the forward or if their is any other greater element it will be at
    		 * head.
    		 */
    		while(!deque.isEmpty() && nums[deque.peekLast()] < nums[index])
    			deque.pollLast();
    		
    		deque.offer(index);
    		
    		/*
    		 * for filling in the result array we will start storing values once the minimum threshold for index
    		 * is achieved going from left to right.
    		 * Example: Suppose our window is of range 3 and our array size = 8. So for the first 2 indices, i.e
    		 * '0' and '1' we won't store the maximum as our window size is not achieved. But once the iterating
    		 * index reaches 'index 2' we get a window of 3, and going forward we will always maintain the window
    		 * of 3.
    		 */
    		if(index >= range - 1) { //range - 1 because of array starting from 0th index
    			result[index - range + 1] = nums[deque.peek()];
    		}
    		//increment the index and move the window forward.
    		index++;
    	}
    	
    	return result;
    }
    
	public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7}; 
		int k = 3;
		
		int[] result = maxSlidingWindow(nums, k);
		
		for(int i : result)
			System.out.print(i + " ");
	}

}
