package array_questions;

import java.util.ArrayList;
import java.util.List;

/*
 * Time Complexity = O(n)
 * Space Complexity = O(K), where 'K' denotes the number of missing array indexes 
 */

/*
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others 
 * appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * 
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as
 * extra space.
 * 
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * 
 * Output:
 * [5,6]
 */

public class FindDisappearedNumbers {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        
        //edge case
        if(nums == null || nums.length == 0)
            return resultList;
        
        //first interate over the array and take the absolute value - 1 at index
        //use that value for jumping to index.
        //If the value at jumped Index is > 0, mark it as negative and move on.
        //In the second iteration, the index values which are non-negative are our result indices
        
        for(int index = 0; index < nums.length; index++){
            int jumpIndex = Math.abs(nums[index]) - 1; //array index start from zero
            
            if(nums[jumpIndex] > 0)
                nums[jumpIndex] *= -1;
        }
        
        //2nd iteration
        for(int index = 0; index < nums.length; index++)
            if(nums[index] > 0)
                resultList.add(index + 1);
        
        return resultList;
    }
	
	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		
		List<Integer> resultList = findDisappearedNumbers(nums);
		
		for(int i : resultList)
			System.out.print(i + " ");
	}

}
