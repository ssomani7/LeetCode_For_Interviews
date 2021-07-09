class Solution:
    def findUnsortedSubarray(nums):
        i = start = end = 1
        b = nums[:]
        b.sort()
        if b == nums:
            return 0
        while(i < len(nums)/2+1):
            if nums[i] != b[i]:
                start = i
                break
            i+=1
            i = 1
        while(i < len(nums)/2+1):
            if nums[-i-1] != b[-i-1]:
                end = -i
                break
            i+=1
        print(start,end)
        print(nums[start-1:end])
        if start == 1 and end == 1:
            return 0    
        else:
            return len(nums[start:end])
    a = findUnsortedSubarray([2,1])
    print(a)