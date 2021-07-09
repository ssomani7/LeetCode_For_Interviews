class Solution:
    def removeDuplicates(nums):
        from collections import Counter
        nums = list(Counter(nums).keys())
    a= removeDuplicates([1,1,2])
    print(a)