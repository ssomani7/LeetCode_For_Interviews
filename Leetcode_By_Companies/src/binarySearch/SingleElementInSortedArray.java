package binarySearch;

/*
 * Time Complexity = O(log n)
 * Space Complexity = O(1)
 */

/*
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except 
 * for one element which appears exactly once. Find this single element that appears only once.
 * 
 * Follow up: Your solution should run in O(log n) time and O(1) space.
 * Example 1:
 * Input: nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * 
 * Example 2:
 * Input: nums = [3,3,7,7,10,11,11]
 * Output: 10
 * 
 * Constraints:
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^5
 */

public class SingleElementInSortedArray {

	   public static int singleNonDuplicate(int[] nums) {
	        int start = 0;
	        int end = nums.length - 1;

	        while (start < end) {
	            // We want the first element of the middle pair,
	            // which should be at an even index if the left part is sorted.
	            // Example:
	            // Index: 0 1 2 3 4 5 6
	            // Array: 1 1 3 3 4 8 8
	            //            ^
	            int mid = start + (end - start) / 2;
	            
	            if (mid % 2 == 1) 
	            	mid--;

	            // We didn't find a pair. The single element must be on the left.
	            // (pipes mean start & end)
	            // Example: |0 1 1 3 3 6 6|
	            //               ^ ^
	            // Next:    |0 1 1|3 3 6 6
	            if (nums[mid] != nums[mid + 1]) 
	            	end = mid;

	            // We found a pair. The single element must be on the right.
	            // Example: |1 1 3 3 5 6 6|
	            //               ^ ^
	            // Next:     1 1 3 3|5 6 6|
	            else 
	            	start = mid + 2;
	        }

	        // 'start' should always be at the beginning of a pair.
	        // When 'start > end', start must be the single element.
	        return nums[start];
	    }
	
	public static void main(String[] args) {
		int[] nums = {1,1,2,3,3,4,4,8,8};
		System.out.println("Single Non Duplicate = " + singleNonDuplicate(nums));
	}

}
