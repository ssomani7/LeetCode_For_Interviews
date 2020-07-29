package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Time Complexity = O(2^N), there are N numbers and 2 decision ( whether to include or leave a number )
 * Space Complexity = Worst case O(2^N), when there are no duplicates in the array.  
 */

/*
 * 
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power 
 * set).
 * Note: The solution set must not contain duplicate subsets.
 * Example:
 * Input: [1,2,2]
 * Output:
 * [
 *  [2],
 *  [1],
 *  [1,2,2],
 *  [2,2],
 *  [1,2],
 *  []
 * ]
 */

public class SubsetsOfDuplicateIntegers {

    public static  List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums); //important here
        backtrack(resultList, new ArrayList<>(), nums, 0);
        return resultList;
    }
    
    public static void backtrack(List<List<Integer>> resultList, List<Integer> tempList, int[] nums, int start){
        resultList.add(new ArrayList<>(tempList));
        
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1])//Will come into effect when you come back from recursion & go ahead in for loop
                continue; //skipping duplicates.
            
            tempList.add(nums[i]);
            backtrack(resultList, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 2};
		List<List<Integer>> resultList = subsetsWithDup(nums);
		
		for(List<Integer> list : resultList)
			System.out.println(list);
	}

}
