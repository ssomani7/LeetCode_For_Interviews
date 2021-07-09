class Solution:
    def validMountainArray(A):  
        if len(A) < 3: return False
        flag = 0
        for i in range(len(A)-1):
            if A[i] == A[i+1]: return False
            if flag == 0: 
                if A[i] > A[i+1]: flag = 1
            else:
                if A[i] <= A[i+1]: return False
        return True
                
    a = validMountainArray([0,3,2,1])
    print(a)