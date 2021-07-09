class Solution(object):
    def isMonotonic(A):
        """
        :type A: List[int]
        :rtype: bool
        """
        if sorted(A) == A or sorted(A, reverse=True) == A:
            return True
        else:
            return False
        # inc = dic = flag = i = 0
        # while(i<len(A)-1):
        #     if A[i+1] - A[i] > 0 and flag == 0:
        #         inc = 1
        #         flag = 1
        #         i+=1
        #         continue
        #     elif A[i+1] - A[i] < 0 and flag == 0:
        #         dic = 1
        #         flag = 1
        #         i+=1
        #         continue
        #     elif A[i+1] - A[i] == 0 and flag == 0:
        #         i+=1
        #         continue
            
        #     if (inc == 1 and A[i+1] - A[i] < 0) or (dic == 1 and A[i+1] - A[i] > 0):
        #         return False
        #     i+=1
        # return True
    a =isMonotonic([1,2,2,3])
    print(a)