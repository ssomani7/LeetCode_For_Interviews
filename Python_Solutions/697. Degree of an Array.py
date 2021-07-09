class Solution:
    def findShortestSubArray(nums):
        left ,right, count = {}, {}, {}
        
        for i, x in enumerate(nums):
            if x not in left: left[x] = i
            right[x] = i
            count[x] = count.get(x,0) + 1
        
        highEle = max(count.values())
        ans = len(nums)
        for each in count:
            if highEle ==  count[each] and right[each] - left[each] + 1 < ans:
                ans = right[each] - left[each] + 1
        return ans

        # def maxEle(temp):
        #     temp = Counter(temp)
        #     val = temp[temp.most_common()[0][0]]
        #     return val
        # if len(nums) == 1:
        #     return 1
        # numsDeg =  maxEle(nums)
        # for i in range(len(nums)):
        #     j=i+1
        #     while(j<len(nums)):  
        #         x = maxEle(nums[i:j+1])
        #         if x == numsDeg and len(nums[i:j+1]) < count:
        #             count = len(nums[i:j+1])
        #         j+=1
        # return count


    a =findShortestSubArray([1,2,2,3,1,4,2])
    print(a)