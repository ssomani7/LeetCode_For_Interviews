''' class Solution:
    def hammingDistance(x,y):
        x = bin(x)[2:].zfill(32)
        y = bin(y)[2:].zfill(32)
        count = 0
        for i in range(min(len(x),len(y))):
            if x[i] != y[i]:
                count +=1
        return count
    a = hammingDistance(680142203,1111953568)
    print(a)
'''
class Solution:
    def hammingDistance(x,y):
        xor_out = x^y
        bit_count = 0
        while(xor_out):
            bit_count += 1
            xor_out = xor_out & xor_out - 1
        return bit_count
    a = hammingDistance(680142203,1111953568)
    print(a)