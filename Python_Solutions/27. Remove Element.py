class Solution:
    def removeElement(nums,val):
        
        i = 0
        while(i<len(nums)):
            if nums[i] == val:
                nums.remove(nums[i])
            else:
                i+=1
        return(nums)

    a = removeElement([3,2,2,3],3)
    print(a)