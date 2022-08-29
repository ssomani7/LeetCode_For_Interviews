package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Time Complexity = O(2^N), there are N numbers and 2 decision ( whether to include or leave a number )
 * [1,2,3] [1(include/leave), 2(include/leave), 3(include/leave)] 2*2*2 = 2^3, so 2^N
 * 
 * Note: Time Complexity is NOT O(N x 2^N), because  the complexity is 2^N as the copy to output list you're 
 * referring to is implementation-dependent. You don't have to perform that copy if you create the subsets 
 * directly in the output list from the beginning.
 * 
 * Space Complexity = O(2^N)
 */

/*
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */

public class SubsetsOfDistinctIntegers {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        //sort the array in place
        Arrays.sort(nums);
        backtrack(resultList, new ArrayList<Integer>(), nums, 0);
        return resultList;
    }
    
    public static void backtrack(List<List<Integer>> resultList, List<Integer> tempList, int[] nums, int start){
        //add the tempList directly to the resultList
        resultList.add(new ArrayList<>(tempList));
        
        //now modify the tempList for the next recursion call, which will be added to the resultList
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(resultList, tempList, nums, i + 1);//'i+1' is for the new start index in recursion
            tempList.remove(tempList.size() - 1); //to add new elements in the tempList and create a new
            //tempList for adding. This also acts as an reference to the previous state for going back
            //in recursion.
        }
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		List<List<Integer>> resultList = subsets(nums);
		
		for(List<Integer> list : resultList)
			System.out.println(list);
	}

}
