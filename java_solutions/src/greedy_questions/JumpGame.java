package greedy_questions;

//Time Complexity = O(n)
//Space Complexity = O(1)

/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * 
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Example 2:
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it
 * impossible to reach the last index.
 */

public class JumpGame {

    public static boolean canJump(int[] nums) {
        //edge case
        if(nums == null || nums.length == 0)
            return true;
        
        //Using peak & valley approach with a max reachable jumping technique.
        //By Greedy method, we calculate a maximum jumping index in the future.
        
        //Only case when we won't be able to reach the last index would be if our array contains 'zero'
        //Only when the array contains 'zero' there is a possiblity of not jumping.
        
        //We handle this by making sure that the index we are on is never greater than the maximum jumping
        //point. If so, we return false.
        
        //nums  = [2,3,1,1,4]
        //index = [0,1,2,3,4]
        
        int maxReachable = 0;
        
        for(int index = 0; index < nums.length; index++){
            if(index <= maxReachable){
                maxReachable = Math.max(maxReachable, nums[index] + index);
            } else {
                return false;
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
		
		System.out.println("Can Jump = " + canJump(nums));
	}

}
