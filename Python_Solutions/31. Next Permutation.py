class Solution:
    def nextPermutation(nums):
        """
        Do not return anything, modify nums in-place instead.
        """
        for i in reversed(range(len(nums)-2,-1)):
            if nums[i] > nums[i-1]:
                nums[i], nums[i152. Maximum Product Subarray.py
                ]

        print(int(''.join(str(x) for x in nums)))

    a = nextPermutation([1,2,3])
    print(a)