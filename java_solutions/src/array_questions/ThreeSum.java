package array_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Time Complexity: O(n ^ 2). Sorting the array takes O(nlogn), so overall complexity is O(nlogn + n^2).
 * This is asymptotically equivalent to O(n ^ 2).
 * 
 * Space Complexity: O(logn) to O(n), depending on the implementation of the sorting algorithm. For the 
 * purpose of complexity analysis, we ignore the memory required for the output.
 */

/*
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all 
 * unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 * 	[-1, 0, 1],
 * 	[-1, -1, 2]
 * ]
 */

public class ThreeSum {

	public static List<List<Integer>> threeSum(int[] nums) {
		//We need to sort array in order to use 2 pointers from left and right side of it and avoid
		 //computation for repeated values.
        Arrays.sort(nums); //important step
        List<List<Integer>> result = new ArrayList<>();
        
        //Don't iterate 'i' over last 2 elements because we will be using 2 pointers called lower and higher 
        //which will take care of that.
        for(int i = 0; i < nums.length - 2; i++){ 
            //Since the nums is sorted, if first number is bigger than 0, it is impossible to have a sum 
            //of 0.
            if(nums[i] > 0) 
                break;
            //avoid duplicate processing
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])){
            	//Check that when 'i' is greater than zero, it is not equal
    			//to the previous number. If it is equal, we need to skip the current 'i' as result for this 'i' 
            	//is same as that for the previous 'i-1'. Just move 'i' to next value in the array.
            	
                int lower = i + 1;
                int higher = nums.length - 1;
                int sum = nums[i] * (-1);
				//We are using 2 pointers, 'lower' which will be used to check the elements left to 'i', hence 'i+1'
				//and 'higher' to check elements from end index, i.e, rightmost side and going towards 'lower'. In this
				//way we will be iterating in both directions of the array at the same time. For 'sum' we are negating
				//the current 'i' value as our input contains -ve integers and we will be summing up the values at 
				//'lower' and 'higher' without negating either of them. Hence, it is necessary to take the -ve of 'i'
				//as 'sum'
                
                while(lower < higher){
                    
                    if(nums[lower] + nums[higher] == sum){ //found a triplet
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[lower]);
                        triplet.add(nums[higher]);
                        result.add(triplet);
                        //now check for different combinations for the same nums[i] by moving lower & higher
                        //pointer
                        while(lower < higher && nums[lower] == nums[lower + 1])
                            lower++;
                        
                        while(lower < higher && nums[higher] == nums[higher - 1])
                            higher--;
                        
                        lower++;
                        higher--;
                        
                    } else if(nums[lower] + nums[higher] < sum)
                        lower++;
                    else
                        higher--;
                }

            }
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> resultList = threeSum(nums);
		
		for(List<Integer> list : resultList)
			System.out.println(list);
	}

}
