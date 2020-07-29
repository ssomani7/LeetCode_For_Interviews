package binarySearch;

/*
 * Time Complexity = O(logn)
 * Space Complexity = O(1)
 * This is standard binary search. Nothing else.
 */

/*
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index 
 * where it would be if it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 * 
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 * 
 * Example 3:
 * Input: [1,3,5,6], 7
 * Output: 4
 * 
 * Example 4:
 * Input: [1,3,5,6], 0
 * Output: 0
 */

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        //binary search. 2 scenarios, target is found & target not found
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end){
            int mid = start + (end - start) / 2; //to avoid overflow
            
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        
        return start;
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 3, 5, 6};
		int target = 7;
		
		System.out.println("Index to be inserted at = " + searchInsert(nums, target));
	}

}
