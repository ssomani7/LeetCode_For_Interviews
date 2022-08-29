package array_questions;

//Time Complexity = O(n)
//Space Complexity = O(1)

/*
 * Snowball Approach : Gather all Zeros together on go and start swapping non-zero value with the first zero
 * 					   in the zero group. In this fashion, all the zeros are collected and are shifted towards
 * 					   the end.
 */

public class MoveZeros {

	public static void moveZerosToEnd(int[] nums) {
		int snowBallSize = 0;
		
		for(int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
			if(nums[currentIndex] == 0)
				snowBallSize++;
			else if (snowBallSize > 0) {
				int nonZeroValue = nums[currentIndex];
				nums[currentIndex] = 0;
				nums[currentIndex - snowBallSize] = nonZeroValue; //replacing the 'first' zero or left most zero
			}
		}
		
		for(int i : nums)
			System.out.print(i + " ");
	}
	
	public static void main(String[] args) {
		int[] nums = {0,1,0,3,76,12};
		moveZerosToEnd(nums);
	}

}