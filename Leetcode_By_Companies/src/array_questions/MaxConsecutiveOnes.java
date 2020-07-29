package array_questions;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */

/*
 * Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:

Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
The maximum number of consecutive 1s is 3.

Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
 */

public class MaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {
        //edge case
        if(nums == null || nums.length == 0)
            return 0;
        
        int result = 0;
        int counter = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                result = Math.max(result, counter);
                counter = 0;
            } else {
                counter++; //You can do a Math.max here everytime as well. But it would be too much comparisons
                //So I did the final comparison below.
            }
        }
        
        result = Math.max(result, counter); //important.
        return result;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,1,0,1,1,1};
		
		System.out.println("Max Consecutive Ones = " + findMaxConsecutiveOnes(nums));
	}	

}
