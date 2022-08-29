package array_questions;

/* Time Complexity = O(n)
 * Space Complexity = O(1)
 * 
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest
 * sum and return its sum.
 * 
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */

public class MaximumSubArray {

	public static int greedyApproach(int[] nums) {
		//edge case
		if(nums == null || nums.length == 0)
			return 0;
		
		int currentMax = 0;
		int maxSoFar = nums[0];
		
		for(int num : nums) {
			currentMax = Math.max(num, currentMax + num);
			maxSoFar = Math.max(maxSoFar, currentMax);
		}
		return maxSoFar;
	}
	
	static int start;
	static int end;
	//Cannot handle all negative input.
	public static int indexCapture(int[] nums) {
		int startingIndex = 0;
		start = 0;
		end = 0;
		int maxSoFar = Integer.MIN_VALUE;;
		int maxEndingHere = 0;
		
		for(int i = 0; i < nums.length; i++) {
			maxEndingHere += nums[i];
			
			if(maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
				start = startingIndex;
				end = i;
			}
			
			//maxEndingHere can be minimum 'Zero'. If found so, set it to zero and start the window from next index
			//This is the tricky part here.
			if(maxEndingHere < 0) {
				maxEndingHere = 0;
				startingIndex = i + 1;
			}
		}
		return maxSoFar;
	}
	
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		
		System.out.println("Greedy Approach = " + greedyApproach(nums));
		System.out.println("Start Index = " + start + " , End Index = " + end + " , Maximum Sub Array = " + 
		indexCapture(nums));
	}

}
