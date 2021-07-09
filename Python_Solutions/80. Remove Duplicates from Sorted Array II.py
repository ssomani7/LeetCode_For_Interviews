class Solution:
    def removeDuplicates(nums):
        if len(nums) == 0: return 0
        flag = 1
        i = 1
        tmp = nums[0]
        l =len(nums)
        while(i<l):
            if nums[i] == tmp:
                if flag == 1:
                    flag = 0
                else:
                    del nums[i]
                    l =len(nums)
                    i-=1
            else:
                tmp = nums[i]
                flag = 1
            i+=1
            print(nums,flag,i)
        
        
    a = removeDuplicates([0,0,1,1,1,1,2,3,3])
    print(a)