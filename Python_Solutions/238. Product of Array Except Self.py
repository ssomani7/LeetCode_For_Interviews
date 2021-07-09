class Solution:
    def productExceptSelf(nums):
        l,r = [],[]
        l.append(1)
        r.append(1)
        temp = 0
        out = []
        for i in range(1,len(nums)):
            temp = nums[i-1] * l[i-1] 
            l.append(temp)
        for j in reversed(range(len(nums)-1)):
            temp = nums[j+1] * r[0]
            r.insert(0,temp)
        for i in range(len(nums)):
            temp = l[i] * r[i]
            out.append(temp)
        return out

    a = productExceptSelf( [1,2,3,4])
    print(a)