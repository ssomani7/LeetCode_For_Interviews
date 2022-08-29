package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * Time complexity : O(∑ k=1 to N) P(N,k)) where P(N, k) = N! / (N - k)! = N (N - 1) ... (N - k + 1)
 * Here first + 1 = k for the expression simplicity. The formula is easy to understand : for each k (each 
 * first) one performs N(N - 1) ... (N - k + 1)N(N−1)...(N−k+1) operations, and k is going through the range 
 * of values from 1 to N (and first from 0 to N - 1).
 * 
 * the algorithm performs better than O(N×N!) and a bit slower than O(N!).
 * 
 * Space complexity : O(N!) since one has to keep N! solutions.
 */

/*
 * Given a collection of distinct integers, return all possible permutations.
 * Example:
 * 
 * Input: [1,2,3]
 * Output:
 * [
 *  [1,2,3],
 *  [1,3,2],
 *  [2,1,3],
 *  [2,3,1],
 *  [3,1,2],
 *  [3,2,1]
 * ]
 */


public class Permutations {

	public static List<List<Integer>> permute(int[] nums) {
		   List<List<Integer>> list = new ArrayList<>();
		   backtrack(list, new ArrayList<>(), nums);
		   return list;
	}

	public static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
		   if(tempList.size() == nums.length){
		      list.add(new ArrayList<>(tempList));
		   } else{
		      for(int i = 0; i < nums.length; i++){ 
		         if(tempList.contains(nums[i])) 
		        	 continue; // element already exists, skip
		         
		         tempList.add(nums[i]);
		         //recursive call here
		         backtrack(list, tempList, nums);
		         tempList.remove(tempList.size() - 1); //important step here to look back for previous state.
		      }
		   }
	} 
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		
		List<List<Integer>> result = permute(nums);
		
		for(List<Integer> list : result)
			System.out.println(list);
	}

}
