package leetcode_medium_questions;

import java.util.LinkedList;
import java.util.List;

/*
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * Example 1:
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * 
 * Example 2:
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 */

/*
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */
public class SummaryRanges {

	public static List<String> getRangeSummary(int[] nums){
		 //edge case
        if(nums == null || nums.length == 0)
            return new LinkedList<String>();
        
        List<String> list = new LinkedList<>();
        int startWindow = 0;
        int index = 0;
        
        while(index < nums.length){
            while(index < nums.length - 1 && (nums[index + 1] - nums[index] == 1)){
                index++;
            }
            
            if(startWindow == index)
                list.add(String.valueOf(nums[startWindow]));
            else
                list.add(String.valueOf(nums[startWindow]) + "->" + String.valueOf(nums[index]));
            
            index++;
            startWindow = index;
        }
        return list;
	}
	
	public static void main(String[] args) {
		int[] nums = {0,2,3,4,6,8,9};
		List<String> resultList = getRangeSummary(nums);
		
		for(String str : resultList)
			System.out.print(str + " ");
	}

}
