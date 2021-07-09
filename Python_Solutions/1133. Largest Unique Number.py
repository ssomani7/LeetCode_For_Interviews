class Solution(object):
    def largestUniqueNumber(A):
        """
        :type A: List[int]
        :rtype: int
        """
        from collections import Counter
        A = Counter(A)
        keys = list(Counter(A).keys())
        keys.sort(reverse=True)
        for each in keys:
            if A[each] == 1:
                return each
        return -1
                
    a = largestUniqueNumber([5,7,3,9,4,9,8,3,1])
    print(a)
        