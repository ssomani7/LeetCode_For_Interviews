class Solution:
    def fourSum(nums,target):
              
        if len(nums) < 4: 
            return []
        nums.sort()
        out = []
        for i in range (len(nums)):
            for j in range(i+1,len(nums)):
                k = j+1
                l = len(nums) - 1
                while(k<l):
                    s = nums[i] + nums[j] + nums[k] + nums[l]
                    if s == target:
                        temp =  [nums[i],nums[j],nums[k],nums[l]]
                        out.append(temp)
                        k+=1
                    elif s < target:
                        k+=1
                    else:
                        l-=1
        out = [sorted(each) for each in out]
        out = [each for each in out if each not in out]
        return set(oout)
                
    a = fourSum([1, 0, -1, 0, -2, 2],0)
    print(a)
        