class Solution:
    def isOneBitCharacter(nums):
        flag = 0
        nFlag = 0
        i = 0
        while(i<len(nums)-1):
            if flag == 1:
                flag =0 
            else:
                if nums[i] == 1:
                    flag = 1
            print(nums[i],flag,i)
            i+=1
            
        return False if flag == 1 else True



    a = isOneBitCharacter([1, 1, 1, 0])
    print(a)