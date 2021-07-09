class Solution:
    def maxProduct(nums):
        n = len(nums)
        if n == 0:
            return 0
        res = maximum = minimum = nums[0]
        for i in range(1,n):
            tmp = minimum
            minimum = min(nums[i], maximum * nums[i], minimum * nums[i])
            maximum = max(nums[i], maximum * nums[i], tmp * nums[i])
            res = max(res, maximum)
            '''print(maximum, end=" ")
            print(minimum, end=" ")
            print(res)'''
        return res

    a = maxProduct( [-2,0,-1])
    print(a)