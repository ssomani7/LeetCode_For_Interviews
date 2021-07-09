class Solution:
    def findMin(nums):
        out = []
        minN = 1000
        if nums[0] < nums[-1]:
            return nums[0]
        if len(nums) == 1 or len(nums) == 2:
            return min(nums)
        minN = 100000
        while(1):       
            l = len(nums)
            if minN > nums[int(l/2)]:
                minN = nums[int(l/2)]
            if nums[int(l/2)] < nums[0]:
                nums = nums[:int(l/2)+1]
            elif nums[int(l/2)] > nums[0]:
                nums = nums[int(l/2):]
            
            if len(nums) == 1 or len(nums) == 2:
                return min(minN,min(nums))
        
    a = findMin( [1,2,3] )
    print(a)