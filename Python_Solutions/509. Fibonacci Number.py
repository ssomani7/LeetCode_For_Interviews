class Solution(object):
    def fib(N):
        """
        :type N: int
        :rtype: int
        """
        out = []
        out.append(0)
        out.append(1)
        out.append(1)
        if N == 0:
            return 0
        elif N == 1 or N == 2:
            return 1
        else:
            for i in range(3,N+1):
                out.append(out[i-1]+out[i-2])
        return out[i]
    a = fib(3)
    print(a)