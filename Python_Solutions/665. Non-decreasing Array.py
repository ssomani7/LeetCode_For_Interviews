class Solution:
    def checkPossibility(nums):
        if len(nums) == 1:
            return True
        flag = 0
        i = 1
        l = len(nums)
        count = 0
        while(i < l):
            if nums[i] < nums[i-1]:
                del nums[i-1]
                i-=1
            if nums == sorted(nums):
                count+=1
            l = len(nums)
            i+=1
        return False if count > 1 else True


                
        
    a = checkPossibility( [4,2,3])
    print(a)