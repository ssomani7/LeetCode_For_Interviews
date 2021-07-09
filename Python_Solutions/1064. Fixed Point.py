class Solution(object):
    def fixedPoint(A):
        while(1):
            h = len(A)
            print(A)
            if A[int(h/2)] == int(h/2):
                return int(h/2)
            elif A[int(h/2)] > int(h/2):
                A = A[:int(h/2)]
            else:
                A = A[int(h/2):]

    a = fixedPoint([-10,-5,0,3,7])
    print(a)