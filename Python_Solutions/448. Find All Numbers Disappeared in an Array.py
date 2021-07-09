class Solution(object):
    def findDisappearedNumbers(nums):
        return list(set(nums) ^ set([x for x in range(1,len(nums)+1)]))
    a = findDisappearedNumbers([4,3,2,7,8,2,3,1])
    print(a)