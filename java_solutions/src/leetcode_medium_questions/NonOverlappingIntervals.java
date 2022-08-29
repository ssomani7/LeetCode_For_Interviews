package leetcode_medium_questions;

import java.util.Arrays;

/*
 * Time Complexity = O(nlogn), for sorting.
 * Space Complexity = O(1), in-place sorting
 */

/*
 * Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest 
 * of the intervals non-overlapping.
 * 
 * Example 1:
 * Input: [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 * 
 * Example 2:
 * Input: [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 * 
 * Example 3:
 * Input: [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 * 
 * Note:
 * You may assume the interval's end point is always bigger than its start point.
 * Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 */

public class NonOverlappingIntervals {

	//Calculate the Number of Non-Overlapping intervals and reduce that count from intervals.length
    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0)
            return 0;
        
        //Calculate the Number of Non-Overlapping intervals and reduce that count from intervals.length
        
        //Sort based on end times
        Arrays.sort(intervals, (arr1, arr2) -> arr1[1] - arr2[1]);
        
        int currentEnd = intervals[0][1];
        int count = 1;
        
        for(int i = 1; i < intervals.length; i++){
            int nextStart = intervals[i][0];
            
            if(nextStart >= currentEnd){ //Non-Overlapping condition
                //update the currentEnd
                currentEnd = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }
	
	public static void main(String[] args) {
		int[][] intervals = {
				{1,2},
				{2,3},
				{3,4},
				{1,3}
		};
		
		System.out.println(eraseOverlapIntervals(intervals));
	}

}
