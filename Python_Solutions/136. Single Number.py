class Solution:
    def singleNumber(nums):
        import collections
        out = collections.Counter(nums)
        minimum = min(out, key=out.get)
        print(minimum)
    singleNumber([4,1,2,1,2])