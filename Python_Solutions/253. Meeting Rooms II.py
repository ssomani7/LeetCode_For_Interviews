class Solution:
    def minMeetingRooms(intervals):
        intervals = sorted(intervals, key=lambda student: student[0])[:]
        if len(intervals) in (0,1):
            return max(len(intervals),0)
        count = 1
        
        for i in range(len(intervals)-1):
            if intervals[i][1] < intervals[i+1][0] and intervals[i+1][0] >=intervals[i][1]:
                count+=1
            elif intervals[i][1] <=intervals[i+1][0] and intervals[i+1][0] <=intervals[i][1]:
                continue
        return count
    a= minMeetingRooms([[7,10],[2,4]])
    print(a)
        