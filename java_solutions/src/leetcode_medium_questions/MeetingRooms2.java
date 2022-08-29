package leetcode_medium_questions;

import java.util.Arrays;

/*
 * Time Complexity: O(NlogN) because all we are doing is sorting the two arrays for start timings and end 
 * timings individually and each of them would contain NN elements considering there are N intervals.
 * 
 * Space Complexity: O(N) because we create two separate arrays of size N, one for recording the start times 
 * and one for the end times.
 */

/*
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 * 
 * Example 1:
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * 
 * Example 2:
 * Input: [[7,10],[2,4]]
 * Output: 1
 */

public class MeetingRooms2 {

    public static int minMeetingRooms(int[][] intervals) {
        //edge case
        if(intervals.length < 1)
            return 0;
        
        int[] meeting_start_time = new int[intervals.length];
        int[] room_earliest_available = new int[intervals.length];
        
        for(int i = 0; i < intervals.length; i++){
            meeting_start_time[i] = intervals[i][0];
            room_earliest_available[i] = intervals[i][1];
        }
        
        Arrays.sort(meeting_start_time);
        Arrays.sort(room_earliest_available);
        
        int new_room = 0;
        
        //We will always increment on meeting_start_time array, because we will always get a room for a meeting to
        //get started, either by allocating a new room or by reusing the room which becomes available at the 
        //earliest.
        for(int i = 0, j = 0; i < meeting_start_time.length; i++){
            if(meeting_start_time[i] < room_earliest_available[j])
                new_room++; //allocate a new room
            else
                j++; //the earliest room has been occupied. So update the next earliest available room time
        }
        
        return new_room;
    }
	
	public static void main(String[] args) {
		int[][] intervals = {
				{0, 30},
				{5, 10},
				{15, 20}
		};
		
		System.out.println(minMeetingRooms(intervals));
	}

}
