package two_pointers;

/*
 * Time Complexity = O(N). Even though they are 2 while loops, both the pointers are always moving in the
 * forward direction. "leftPtr" is not set to zero every time "rightPtr" changes. In worst case, each
 * element is processed twice, so its O(N) + O(N) = O(2N) which is O(N).
 * 
 * Worst Case Example = arr is {7, 7, 7, 7} and target is 7. So our answer is "1". But each and every
 * element satisfies the answer, so we end up checking each element as window. 
 * 
 * Space Complexity = O(1)
 */

/*
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous 
 * subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * 
 * Example: 
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 */

public class MinimumSizeSubarraySum {

    public static int minSubArrayLen(int s, int[] nums) {
        //edge case
        if(nums == null || nums.length == 0)
            return 0;
        
        //two pointer solution
        int leftPtr = 0;
        int rightPtr = 0;
        int window = Integer.MAX_VALUE;
        int runningSum = 0;
        
        while(rightPtr < nums.length){
            runningSum += nums[rightPtr];
            
            /*
             * If our runningSum is >= s, it means we have found a candidate window.
             * Now we will shrink the window from the left hand side, and see again if the new shrinked
             * window is still a candidate.
             * In order to check the new shrinked window as a candidate, we need to reduce the runningSum.
             * Since we are shrinking the window from the left, we will subtract the value in the array at
             * leftPtr. This will give us the new window, with new 'runningSum'.
             * Since our window is updated, we need to move our leftPtr to the right by 1 direction and
             * again check if the runningSum in the new window makes the window candidate.
             */
            while(runningSum >= s){
                //"+1", because the result expected is array length. Array indexes start from 0, hence
                //+1.
                window = Math.min(window, rightPtr - leftPtr + 1);
                runningSum -= nums[leftPtr];//Updating the window
                leftPtr++;//Updating the window
            }
            
            rightPtr++;
        }
        
        return window == Integer.MAX_VALUE ? 0 : window;
    }
	
	public static void main(String[] args) {
		int[] nums = {2, 3, 1, 2, 4, 3};
		int s = 7;
		System.out.println(minSubArrayLen(s, nums));
	}

}