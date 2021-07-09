class Solution:
    def maxProfit(prices):
        out = 0
        maxV = 0
        flag = 0
        for i in range(len(prices)-1):
            if prices[i] < prices[i+1] and flag == 0:
                flag = 1
                temp = prices[i+1] - prices[i]
                if maxV < temp: maxV = temp
                    
    a = maxProfit( [7,1,5,3,6,4])
    print(a)