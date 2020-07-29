package array_questions;

import java.util.ArrayList;
import java.util.List;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(1), don't count the result list as an extra space.
 */

/*
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear 
 * once.
 * 
 * Find all the elements that appear twice in this array.
 * 
 * Could you do it without extra space and in O(n) runtime?
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [2,3]
 */

public class FindAllDuplicatesInArray {

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
            int indexToBeJumped = Math.abs(nums[i]) - 1; //numbers are from 1 to array length;
            
            if(nums[indexToBeJumped] < 0)
                result.add(indexToBeJumped + 1);
            
            //flip the sign bit
            nums[indexToBeJumped] = - nums[indexToBeJumped];
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		List<Integer> result = findDuplicates(nums);
		
		for(Integer i : result)
			System.out.print(i + ", ");
	}

}
