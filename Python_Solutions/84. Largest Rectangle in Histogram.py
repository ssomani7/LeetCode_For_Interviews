class Solution:
    def largestRectangleArea(heights):
        # divide and conquer
        maxA = 0
        while(1):
            minE = num.index(min(num))
            if max
            if nums[:]

        # Brute force N^2
        # maxA = heights[0]
        # for i in range(len(heights)-1):
        #     for j in range(i+1,len(heights)):
        #         if heights[i] == 0:
        #             break
        #         temp = min(heights[i:j+1]) * len(heights[i:j+1])
        #         if maxA < temp:
        #             maxA = temp
        # return heights[-1] if maxA < heights[-1] else maxA 

    a = largestRectangleArea([9,0])
    print(a)
        