package array_questions;

import java.util.HashMap;
import java.util.Map;

/*
 * Time complexity : O(n). The entire array is traversed only once.
 * Space complexity : O(n). Maximum size of the HashMap mapmap will be 'n', if all the elements are either 1 or 0.
 */

/*
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * 
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 */

public class ContiguousArray {

	public static int findMaxLength(int[] nums) {
		/*
		 * Since the array consists of only binary input, there is a trick to solve this problem.
		 * 
		 * Trick : Keep a 'count' variable initialized to 0. Whenever you come across a '0' decrease the count by 1
		 * and when come across '1' increment the count by '1'. And keep recording the array index from '1'
		 * instead of '0'. MaxLength comparision only on repeated index occcurence with the count key or when
		 * count == 0.
		 * 
		 * In this fashion, if the count at a particular index becomes 'Zero', that means we have seen equal
		 * number of zeros and ones.
		 * Idea is similar to graph visualization of buy and sell stocks.
		 * Maintain a HashMap of 'count' with their initial indexes occuring only. Whenever you come across a
		 * existing 'count' key further down the array, take the difference of this currentIndex and the first
		 * index you saved in the hashmap and assign the greater to the maxLength variable.
		 * 
		 * Trick is that, whenever the 'count' gets 'ZERO' value, we need to compare it with maxLength.
		 * maxLength will only be compared if there is repeatance of count indexes or if count with a zero
		 * value occurs even once.
		 * 
		 * For handling the zero value case, you can put a dummy entry into hashmap with 0,-1 which will
		 * simulate the first occurence of 'zero' as the repeat occurence of index and the code will be generic.
		 * 
		 */
		
        //edge case
        if(nums == null || nums.length == 0)
            return 0;
                
        //HashMap and reoccurence
        Map<Integer, Integer> firstRecordingMap = new HashMap<>();
        firstRecordingMap.put(0, -1);
        
        int counter = 0;
        int maxLength = 0;
        
        for(int index = 0; index < nums.length; index++){
           if(nums[index] == 0)
               counter++;
            else
                counter--;
            
            if(firstRecordingMap.containsKey(counter)){
                maxLength = Math.max(maxLength, index - firstRecordingMap.get(counter));
            } else
                firstRecordingMap.put(counter, index);
        }
        return maxLength;
	}
	
	public static void main(String[] args) {
		int[] nums = {0,0,0,1,1,1,0};
//		int[] nums = {0,1,1};
		System.out.println("Max Contiguous Sub Array Length of equal 0's and 1's = " + findMaxLength(nums));
	}

}
