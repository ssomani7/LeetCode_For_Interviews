class Solution(object):
    def arrayPairSum(nums):
        nums.sort()
        nums = sum(nums[::2])
        return nums
    a = arrayPairSum([1,4,3,2])
    print(a)
        