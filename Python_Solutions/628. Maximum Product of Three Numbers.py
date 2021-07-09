class Solution:
    def maximumProduct(self, nums: List[int]) -> int:
        x=sorted(nums)
        temp = x[0] * x[1] * x[-1]
        temp2 = x[-3] * x[-2] * x[-1]
        return max(temp,temp2)