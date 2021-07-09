class Solution:
    def mySqrt(x):
        sqrt = []
        sqrs = {}
        if not isinstance(x,int):
            return False
        def closest(lst, K): 
            if K in lst:
                return K
            else:
                a =  lst[min(range(len(lst)), key = lambda i: abs(lst[i]-K))] 
                return lst[lst.index(a)-1]
        for each in range(0,x):
            sqrt.append(each*each)
            sqrs[each*each] = each
        print(sqrs[closest(sqrt,x)])
    a = mySqrt(55)