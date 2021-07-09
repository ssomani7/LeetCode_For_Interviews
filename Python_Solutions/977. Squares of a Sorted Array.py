class Solution:
    def sortedSquares(A):
        out = []
        for each in A:
            out.append(each*each)
        out.sort()
        return out
    a = sortedSquares([-4,-1,0,3,10])
    print(a)
        