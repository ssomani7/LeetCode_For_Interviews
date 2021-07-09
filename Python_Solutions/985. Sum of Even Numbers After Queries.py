class Solution(object):
    def sumEvenAfterQueries(A, queries):
        """
        :type A: List[int]
        :type queries: List[List[int]]
        :rtype: List[int]
        """
        total = sum(list(filter(lambda x: (x % 2 == 0), A)))
        out = []
        for each in queries:
            temp = A[each[1]]
            A[each[1]] = A[each[1]] + each[0]
            if A[each[1]]%2 == 0:
                total = total + A[each[1]]
            if temp%2 == 0:
                total = total - temp
            out.append(total)
        return out

    a = sumEvenAfterQueries(  [1,2,3,4],[[1,0],[-3,1],[-4,0],[2,3]])
    print(a)