package leetcode_easy_questions;

/*
 * Time Complexity = O(N log N), sorting array in place
 * Space Complexity = O(1), in place sorting
 */

/*
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 * 
 * Example 1:
 * Input: [[0,30],[5,10],[15,20]]
 * Output: false
 * 
 * Example 2:
 * Input: [[7,10],[2,4]]
 * Output: true
 */

import java.util.Arrays;

public class MeetingRoomsYesOrNo {

    public static boolean canAttendMeetings(int[][] intervals) {
        //edge case
        if(intervals.length <= 1)
            return true;
        
        //Sorting the array based on their first element
        Arrays.sort(intervals, (arr1, arr2) -> arr1[0] - arr2[0]);
        
        int[] currentInterval = intervals[0];
               
        for(int i = 1; i < intervals.length; i++){
            
            int currentEnd = currentInterval[1];
            int nextBegin = intervals[i][0];

            if(currentEnd > nextBegin)
                return false;
            else
                currentInterval = intervals[i];                        
        }
        
        return true; //default
    }
	
	public static void main(String[] args) {
		int[][] intervals = {
				{1,3},
				{2,6},
				{8,10},
				{15,18}
		};
		
		System.out.println(canAttendMeetings(intervals));
	}

}
