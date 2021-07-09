class Solution:
    def minCostClimbingStairs(cost):
        f1 = f2 = 0
        for x in reversed(cost):
            f1, f2 = x + min(f1, f2), f1
            print(f1,f2)
        return min(f1, f2)

    a = minCostClimbingStairs([10, 15, 20])
    print(a)