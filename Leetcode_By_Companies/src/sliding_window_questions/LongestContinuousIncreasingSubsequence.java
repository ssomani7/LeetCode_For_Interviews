package sliding_window_questions;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */

/*
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence 
 * (subarray).
 * 
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 *  
 * Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are 
 * separated by 4. 
 * 
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2], its length is 1. 
 */

public class LongestContinuousIncreasingSubsequence {

    public static int findLengthOfLCIS(int[] nums) {
        //sliding window
        int end = 0;
        int start = 0;
        int maxLen = 0;
        
        while(end < nums.length){
            //Important double check of 'end' to avoid out of index error.
            while(end < nums.length - 1 && nums[end] < nums[end + 1])
                end++;
            
            maxLen = Math.max(maxLen, end - start + 1);
            
            end = end + 1;
            start = end;
        }
        
        return maxLen;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,3,5,4,7};
		
		System.out.println("Longest Continuous Increasing Subsequence = " + findLengthOfLCIS(nums));
	}

}
