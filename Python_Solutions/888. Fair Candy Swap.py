class Solution:
    def fairCandySwap(A,B):
        Sa, Sb = sum(A), sum(B)
        setB = set(B)
        for x in A:
            if x + (Sb - Sa) / 2 in setB:
                return [x, x + (Sb - Sa) / 2]
    
    a = fairCandySwap([8,73,2,86,32],[56,5,67,100,31])
    print(a) 
        