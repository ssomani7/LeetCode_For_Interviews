class Solution:
    def twoSum(nums, target):
        for i in range(len(nums)):
            if target - nums[i] in nums[i+1:]:
                return [i,nums[i+1:].index(target - nums[i])+1]
    
    a = twoSum([3,2,4],6)
    print(a) 