class Solution(object):
    def findPairs(nums, k):
        nums.sort()
        res , dic= 0 , {}
        for i in nums:
            print(i)
            dic[i] = dic[i]+1 if i in dic else 1
        for i in dic.keys():
            if (i+k in dic and k>0) or (k==0 and dic[i]>1):
                res += 1
        return res 
    a = findPairs([3, 1, 4, 1, 5],2)
    print(a)
        