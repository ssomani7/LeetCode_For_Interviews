package leetcode_medium_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Time complexity : O(nlogn), Other than the sort invocation, we do a simple linear scan of the list, so the 
 * runtime is dominated by the O(nlgn) complexity of sorting.
 * 
 * Space complexity : O(1), sorting done in-place
 */

/*
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * 
 * Example 2:
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */

public class MergeIntervals {

	 public static int[][] merge(int[][] intervals) {
	        //edge case
	        if(intervals.length <= 1)
	            return intervals;
	        
	        //First sort the arrays on the basis of their starting element in individual array
	        Arrays.sort(intervals, (arr1, arr2) -> arr1[0] - arr2[0]);
	        
	        //We don't know the size of the output array. So first use list and then convert to array
	        List<int[]> outputList = new ArrayList<>();
	        
	        //Put the first sorted array in the outputList. If there is an overlap we will be changing it
	        //within the outputList.
	        //If there is no overlap, we will assign the new interval to the current interval, add it to the
	        //outputList and keep checking for next intervals with the updated current interval
	        int[] current_interval = intervals[0];
	        
	        //adding it to the outputList
	        outputList.add(current_interval);
	        
	        for(int[] interval : intervals){
	            int current_begin = current_interval[0]; //no use, just kept for understanding the flow.
	            int current_end = current_interval[1];
	            int next_begin = interval[0];
	            int next_end = interval[1];
	            
	            //Overlap when current array end is >= next array start, update the current interval in the output
	            //list
	            if(current_end >= next_begin)
	                current_interval[1] = Math.max(current_end, next_end);
	            else {
	                //we got a non-overlapping interval.
	                //make it the current interval, add to the list, and move ahead in the array for comparisons
	                current_interval = interval;
	                outputList.add(current_interval);
	            }
	        }
	        
	        return outputList.toArray(new int[outputList.size()][]);
	    }
	
	public static void main(String[] args) {
		int[][] intervals = {
				{1,3},
				{2,6},
				{8,10},
				{15,18}
		};
		
		int[][] result = merge(intervals);
		
		for(int[] i : result) {
			System.out.print("[" + i[0] + ", " + i[1] + "]");
			System.out.println();
		}
			
	}

}
