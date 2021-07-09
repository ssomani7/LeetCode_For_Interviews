class Solution(object):
    def heightChecker(heights):
        counter = 0
        temp = heights[:]
        heights.sort()
        for i in range(len(heights)):
            if heights[i] != temp[i]:
                counter+=1
        return counter
    a = heightChecker([1,1,4,2,1,3])
    print(a)