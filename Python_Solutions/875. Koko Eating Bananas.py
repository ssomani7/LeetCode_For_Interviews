class Solution:
    def minEatingSpeed(piles, H):
        minH = float("inf")
        minI = -1
        piles.sort(reverse=True)
        print(piles)
        def check(n):
            count = 0
            for each in piles:
                count+= each//n 
                if each%n != 0: count+= 1
                print(each,n,count)
            return count
        
        flag = 0
        prev = -1
        for i in range(len(piles)):
            if flag == 0:
                ans = check(piles[i])
                if ans < minH: 
                    minH = ans
                    minI = piles[i]
                if ans > H: flag = 1 
                if ans == H: return minI
            if flag == 1:
                for each in range(piles[i]+1,piles[i-1]):
                    ans = check(each)
                    if ans < minH: 
                        minH = ans
                        minI = each
                    if ans == H: return minI
        return minI
    a = minEatingSpeed([3,6,7,11],8)
    print(a)