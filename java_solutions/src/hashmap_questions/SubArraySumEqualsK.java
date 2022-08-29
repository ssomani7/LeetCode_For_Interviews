package hashmap_questions;

import java.util.Map;
import java.util.HashMap;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(n)
 */

/*
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays 
 * whose sum equals to k.
 * 
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * 
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */

public class SubArraySumEqualsK {

	public static int subarraySum(int[] nums, int k) {
        //edge case
        if(nums == null || nums.length == 0)
            return 0;
        
        //We will be using the sum seen so far and reduce it from the target 'k', similar to
        //two sum technique. As we are calculating the running sum, our sum will go beyond the target
        //and hence we are searching for 'sum - k'
        
        //We only need to initialize the HashMap with key 0 and value 1. This is for the case when our
        //sum equals the target itself. It can happen naturally as well in the array if we hadn't
        //initialized it, but we need to take care of it when it happens the first time.
        
        //For the first time when sum == k, we won't have an entry in the HashMap for sure. So just
        //handle that by pre initializing HashMap with (0,1)
        
        int sum = 0;
        int result = 0;
        Map<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0,1);
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            
            if(hmap.containsKey(sum - k))
                result += hmap.get(sum - k);
            
            hmap.put(sum, hmap.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[] nums = {3,4,7,2,-3,1,4,2};
		int k = 7;
		
		System.out.println("Number of Sub Arrays summing upto k (" + k + ") = " + subarraySum(nums, k));
	}

}
