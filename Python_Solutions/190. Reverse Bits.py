class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(n):
        a = ""
        i= 0
        while(n != 0):
            a+= str(n%2)
            n //= 2
        if len(str(2))
        print(a[::-1])
    a = reverseBits(43261596)
    print(a)