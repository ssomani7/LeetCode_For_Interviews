class Solution:
    def merge( intervals):
        intervals = sorted(intervals, key=lambda student: student[0])[:]
        out = []
        l = len(intervals)-1
        i = 0
        while(i<l):
            if intervals[i+1][0] <= intervals[i][1]:
                temp  = [intervals[i][0],max(intervals[i+1][1],intervals[i][1])]
                intervals[i] = temp
                del intervals[i+1]
                l = len(intervals)-1
                # print(temp,intervals,intervals[i],intervals[i+1])
            else:
                i+=1
        return intervals
    a = merge( [[0, 30],[5, 10],[15, 20]])
    print(a)