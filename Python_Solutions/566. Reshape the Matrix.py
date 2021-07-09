class Solution:
    def matrixReshape(nums,r,c):
        out = []
        s = ""
        for each in nums:
            s= s + str(', '.join(str(x) for x in each).replace('[','').replace(']','').replace(',','').replace(' ','').replace('-',''))
        temp = []
        i = 0
        if r*c > len(s) or r*c < len(s):
            return nums
        while(i<len(s)):
            print(s[i:i+c])
            print(i,c)
            out.append([x for x in s[i:i+c]])
            i+=c
        return out
    a = matrixReshape([[2,5],[8,4],[0,-1]],6,1)
    print(a)