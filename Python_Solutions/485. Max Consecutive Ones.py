class Solution(object):
    def findMaxConsecutiveOnes(nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        maxOne = count = i = 0
        while(i<len(nums)):
            if nums[i] == 1:
                count +=1
                if maxOne < count:
                    maxOne = count 
            else:
                count = 0
            i+=1
        print(maxOne)
        



    a = findMaxConsecutiveOnes([1,1,0,1,1,1])
    print(a)