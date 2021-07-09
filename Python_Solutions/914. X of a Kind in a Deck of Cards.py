class Solution:
    def hasGroupsSizeX(deck):
        import math
        dic = {}
        for each in deck:
            if each not in dic:
                dic[each] = 1
            else:
                dic[each] += 1
        out = [dic[each] for each in dic]
        m = min(out)
        if m >= 2:
            for each in out:
                if math.gcd(each,m) >=2 :
                    return True
                else:
                    return False
        return False

        
    a = hasGroupsSizeX(  [1,1,2,2,2,2])
    print(a)