class Solution(object):
    def missingNumber(nums):
        n = int((len(nums))*(len(nums)+1)/2  - sum(nums))
        return n

    a= missingNumber([9,6,4,2,3,5,7,0,1])
    print(a)