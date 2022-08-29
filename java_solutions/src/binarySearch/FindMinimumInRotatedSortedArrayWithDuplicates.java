package binarySearch;

/*
 * Time complexity: on average O(log N) where N is the length of the array, since in general it is a binary 
                                    2
​search algorithm. However, in the worst case where the array contains identical elements (i.e. case #3 
nums[pivot]==nums[high]), the algorithm would deteriorate to iterating each element, as a result, the time 
complexity becomes O(N).

Space complexity : O(1), it's a constant space solution.
 */

public class FindMinimumInRotatedSortedArrayWithDuplicates {

    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        while(start < end){
            int mid = start + (end - start) / 2;
            
            if(nums[mid] > nums[end])
                start = mid + 1;
            else if (nums[mid] < nums[end])
                end = mid;
            else //When num[mid] == num[hi], we couldn't be sure the position of minimum in mid's left or right, so just let upper bound reduce one.
                end--;
        }
        
        return nums[start];
    }
	
	public static void main(String[] args) {
		int[] nums = {2,2,2,0,1};
		System.out.println(findMin(nums));
	}

}
