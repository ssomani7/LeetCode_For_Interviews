package binarySearch;

/*
 * Time Complexity = O(log n) from the binary search. For best case it is O(1) when the number of elements actually missing from the
 * given array is less than k. 
 * Space Complexity = O(1)
 */

/*
 * Given a sorted array A of unique numbers, find the K-th missing number starting from the leftmost number of 
 * the array.
 * 
 * Example 1:
 * Input: A = [4,7,9,10], K = 1
 * Output: 5
 * 
 * Explanation: The first missing number is 5.
 * 
 * Example 2:
 * Input: A = [4,7,9,10], K = 3
 * Output: 8
 * 
 * Explanation: The missing numbers are [5,6,8,...], hence the third missing number is 8.
 * 
 * Example 3: Input: A = [1,2,4], K = 3
 * Output: 6
 * 
 * Explanation: The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
 * 
 * Note:
 * 1 <= A.length <= 50000
 * 1 <= A[i] <= 1e7
 * 1 <= K <= 1e8
 */

public class MissingElementInUniqueSortedArray {

    public static int missingElement(int[] nums, int k) {
    	int total_number_of_elements_actually_present_in_the_array = nums.length;
    	int last_index = nums.length - 1;
    	
    	//from start to end of the array
        int total_number_of_elements_that_should_be_present = nums[last_index] - nums[0] + 1;
        
        //elements missing within range of start to end given in the array.
        int number_of_elements_missing_from_the_array = total_number_of_elements_that_should_be_present - 
        												total_number_of_elements_actually_present_in_the_array;
       
//        System.out.println(number_of_elements_missing_from_the_array);
        
        //When number of elements missing from an array are less than 'k'
        if(number_of_elements_missing_from_the_array < k)
        	return nums[last_index] + k - number_of_elements_missing_from_the_array;
        
        //Binary search
        int start = 0;
        int end = nums.length - 1;
        
        while(start < end - 1) {
        	int mid = start + (end - start) / 2;
        	int number_of_missing_elements = nums[mid] - nums[start] - (mid -start);
        	
        	if(number_of_missing_elements >= k) {
        		// when the number is larger than k, then the index won't be located in (m, h]
        		end = mid;
        	} else {
        		// when the number is smaller than k, then the index won't be located in [l, m), update 
        		//k -= number_of_missing_elements
        		k -= number_of_missing_elements;
        		start = mid;
        	}
        }
    	
    	return nums[start] + k;
    }
	
	public static void main(String[] args) {
		int[] nums = {4,7,9,10};
		int k = 3;
		System.out.println(missingElement(nums, k));
	}

}
