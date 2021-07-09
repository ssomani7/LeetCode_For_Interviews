class Solution:
    def maxProfit(prices):
        return sum(prices[a+1] - prices[a] for a in range(len(prices)-1) if prices[a] < prices[a+1])
    a = maxProfit([7,1,5,3,6,4])
    print(a)