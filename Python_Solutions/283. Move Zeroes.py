class Solution:
    def moveZeroes(nums):
        """
        Do not return anything, modify nums in-place instead.
        """
        i = 0
        for j in range(len(nums)):
            if nums[j] != 0:
                print(nums[i], nums[j])
                nums[i], nums[j] = nums[j], nums[i]
                i += 1
        print(nums)
    moveZeroes(  [0,1,0,3,12])