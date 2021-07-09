class Solution:
    def majorityElement(nums):
        nums.sort()
        n=len(nums)
        return nums[n//2]
    a = majorityElement([2,2,1,1,1,2,2])
    print(a)
