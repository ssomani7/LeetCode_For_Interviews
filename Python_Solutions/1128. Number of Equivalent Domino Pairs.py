from collections import defaultdict

class Solution:
    def numEquivDominoPairs(dominoes):
        seen = defaultdict(int)
        ans = 0
        for x, y in dominoes: 
            print(x,y)
            if x > y: x, y = y, x
            key = 10*x + y
            ans += seen[key]
            seen[key] += 1
        return ans 
    a = numEquivDominoPairs([[1,2],[2,1],[3,4],[5,6]])
    print(a)