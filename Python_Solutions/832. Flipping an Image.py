class Solution:
    def flipAndInvertImage(A):
        return [i for i, c in enumerate(A) if i == c][0]
       
    a = flipAndInvertImage([-10,-5,0,3,7])
    print(a)