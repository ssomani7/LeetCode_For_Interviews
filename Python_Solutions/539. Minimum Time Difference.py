class Solution:
    def findMinDifference(timePoints):
        timeInM = sorted([int(v[:2])*60 + int(v[3:]) for v in timePoints])
        print(timeInM)
        min_diff = timeInM[0] - timeInM[-1] + 24*60
        print(min_diff)
        for i in range(len(timeInM)-1):
            min_diff = min(timeInM[i+1] - timeInM[i] , min_diff)
        return min_diff
    a = findMinDifference(["23:59","00:00"])
    print(a)