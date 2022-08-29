package array_questions;

import java.util.Deque;
import java.util.ArrayDeque;

/*
 * Time Complexity: O(N), where N is the length of Array. Even though we have 2 inner while loops, they are
 * operating on dequeue indices, and our 'i' pointer is always moving forward and nothing is being reset to
 * zero.
 * Space Complexity: O(N).
 */

public class ShortestSubarrayWithSumAtleastK {

    public static int shortestSubarray(int[] nums, int target) {
        int N = nums.length;
        int res = N + 1;
        
        int[] cumulativeSum = new int[N + 1];
        
        //Cumulative sum of nums array. Example: nums = [3, -2, 5] and target = 4.
        //So our cumulative sum will be [0, 3, 1, 6]. Cumulative sum is basically running sum, that's why
        //we need array length + 1. There is nothing to left of nums[0], so cumulativeSum[0] = 0.
        //Then, 0 + 3 = 3, 3 + (-2) = 1, 1 + 5 = 6
        for (int i = 0; i < N; i++) 
        	cumulativeSum[i + 1] = cumulativeSum[i] + nums[i];
        
        Deque<Integer> indexDequeue = new ArrayDeque<>();
        
        /*
         * first while loop serves two purposes: 
         * (1) remove the obvious worse candidates and 
         * (2) left an increasing queue list of candidates.
         * 
         * The second loop can be guaranteed to narrow down to the best solution simply by checking from 
         * the beginning one by one. Why? because of (2), all the candidates are in increasing order now.
         */
        
        for (int i = 0; i < N + 1; i++) {        	
        	//This while loop helps us eliminate the candidate indexes of the window that occur from the
        	//start of the nums array. This is because we are interested in shortest subarray length and
        	//our "i" will always be moving forward. Since we are pushing the indexes in the dequeue from
        	//back, the current "i" (which is yet to be pushed in the dequeue) is still a better candidate
        	//for shorter subarray length
            while (indexDequeue.size() > 0 && cumulativeSum[i] <= cumulativeSum[indexDequeue.getLast()])
            	indexDequeue.pollLast();
        	
            //This while loop helps us store the possible candidates upto nums[i-1] which will have sum
        	// greater than equal to K.
        	while (indexDequeue.size() > 0 && cumulativeSum[i] - cumulativeSum[indexDequeue.getFirst()] >=  target)
                res = Math.min(res, i - indexDequeue.pollFirst());
            
            indexDequeue.addLast(i);
        }
        
        return res <= N ? res : -1;
    }
	
	public static void main(String[] args) {
		int[] nums = {3, -2, 5};
		int target = 4;
		System.out.println(shortestSubarray(nums, target));
	}

}