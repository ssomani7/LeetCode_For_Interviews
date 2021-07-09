class Solution:
    def canThreePartsEqualSum(A):
        s = int(sum(A)/3)
        i = 0
        su =0
        c = 3
        temp = []
        while(i < len(A)-1):
            su += A[i]
            if c == 0:
                break
            if su == s:
                su = 0
                c-=1
            if su > s:
                return False
            temp.append(A[i])
            i+=1 
            print(s,c,temp)
        if len(temp) != len(A):
            return False
        else:
            return True 

    a = canThreePartsEqualSum([3,3,6,5,-2,2,5,1,-9,4])
    print(a)