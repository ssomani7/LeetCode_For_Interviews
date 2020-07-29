package greedy_questions;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */

/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array. Each
 * element in the array represents your maximum jump length at that position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * Example:
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * 
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Note: You can assume that you can always reach the last index.
 */

public class MinimumJumpsToLast {

    public static int minimumJumps(int[] nums) {
        int furthestPossible = 0;
        int end = 0;
        int jumps = 0;
        
        //because given that we can always reach the index
        for(int index = 0; index < nums.length - 1; index++){
            furthestPossible = Math.max(furthestPossible, index + nums[index]);
            
            if(index == end){
                jumps++;
                end = furthestPossible;
            }
        }
        return jumps;
    }
	
	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
		
		System.out.println("Minimum Jumps for reaching Last Index = " + minimumJumps(nums));
	}

}
