package dynammic_programming;

import java.util.Arrays;

/*
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money 
 * stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum 
 * amount of money you can rob tonight without alerting the police.
 * 
 * Example 1:
 * Input: [8,0,1,8]
 * Output: 16
 * Explanation: Rob house 1 (money = 8) and then rob house 4 (money = 8).
 * Total amount you can rob = 8 + 8 = 16.
 */

/*
 * A robber has 2 options: a) rob current house 'i'; 
 *                         b) don't rob current house.
 * If an option "a" is selected it means she can't rob previous "i-1" house but can safely proceed to the one before
 * previous "i-2" and gets all cumulative loot that follows.
 * If an option "b" is selected the robber gets all the possible loot from robbery of "i-1" and all the following 
 * buildings.
 * So it boils down to calculating what is more profitable:
 * 
 * In short it is "rob current house + aggregate_of_adjacent-1" or "aggregate_of_adjacent"
 * Trick: store the "aggregate_of_adjacent" in temp, then run both the possibilites of robbing and assign the max
 * outcome to "aggregate_of_adjacent", now update the "aggregate_of_adjacent-1" with the value in the temp.
 */

/*
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */
		

public class HouseRobberArrayVersion {

	//Space = O(1), prefer this method.
	public static int rob(int[] nums) {
		//edge case
		if(nums.length == 0)
			return -1;
		
		int current_aggregate_adjacent = 0;
		int aggregate_before_adjacent = 0;
		
		for(int current_house : nums) {
			int temp = current_aggregate_adjacent;
			//2 options ==> 1) rob 2) !rob
			//rob = current num + aggregate_before_adjacent
			//!rob = current_aggregate_adjacent
			current_aggregate_adjacent = Math.max(current_house + aggregate_before_adjacent, 
												  current_aggregate_adjacent);
			aggregate_before_adjacent = temp;
		}
		
		return current_aggregate_adjacent;
	}
	
	//Space = O(n)
	public static int robUsingMemoization(int[] nums) {
		//edge case
		if(nums.length == 0)
			return -1;
		
		//mapping of nums and dp is i to i + 1
		int[] dp = new int[nums.length + 1];
		dp[0] = 0; //For the first element in nums there is no previous adjacent, i.e, no 'i-2'
		dp[1] = nums[0]; //First element of nums will be the max robbery amount starting
		
		for(int i = 1; i < nums.length; i++) {
			//dp[i] represents current_aggregate_adjacent, which is the choice of not robbing.
			//dp[i - 1] represents the aggregate_before_adjacent, which along with the current house is the choice
			//for robbing.
			dp[i + 1] = Math.max(nums[i] + dp[i - 1], dp[i]);
		}
		
		return dp[nums.length]; //last element of the 'dp' array
	}
	
	//Recursion method runs in O(n) time. Space complexity is O(n)
	static int[] memo;
	public static int robUsingRecursion(int[] nums) {
	    memo = new int[nums.length + 1];
	    Arrays.fill(memo, -1);
	    return robUsingRecursion(nums, nums.length - 1);
	}

	public static int robUsingRecursion(int[] nums, int i) {
	    if (i < 0) {
	        return 0;
	    }
	    if (memo[i] >= 0) {
	        return memo[i];
	    }
	    int result = Math.max(robUsingRecursion(nums, i - 2) + nums[i], robUsingRecursion(nums, i - 1));
	    memo[i] = result;
	    return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,7,9,3,1,102};
		
		System.out.println("Max Money Robbed = " + rob(nums));
		System.out.println("Using Memoization Max Money Robbed = " + robUsingMemoization(nums));
		System.out.println("Using Recursion Max Money Robbed = " + robUsingRecursion(nums));
	}

}
