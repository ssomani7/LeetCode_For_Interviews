package trick_questions;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 * Approach = Boyer-Moore Candidate Voting Algorithm
 */

/*
 * Given an array of size n, find the majority element. The majority element is the element that appears more 
 * than ⌊ n/2 ⌋ times.
 * 
 * "Very Important" : You may assume that the array is non-empty and the majority element always exist in the 
 * array. Only then the candidate algorithm can be applied.
 * 
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElement {

	public static int getCandidate(int[] nums) {
		//edge case
		if(nums == null || nums.length == 0)
			return 0;
		
		int candidate = nums[0];
		int countOfCandidate = 1;
		
		for(int  i = 1; i < nums.length; i++) {
			if(countOfCandidate == 0) {
				//make new candidate
				candidate = nums[i];
				//increase the count
				countOfCandidate++;
			} else if(candidate == nums[i])
				countOfCandidate++;
			else
				countOfCandidate--;
		}
		
		return candidate;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,2,1,1,1,2,2};
		
		System.out.println("Candidate Algorithm Result = " + getCandidate(nums));
	}

}
