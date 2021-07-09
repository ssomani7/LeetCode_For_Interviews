class Solution:
    def trap(height):
        # Idea is check for immediet higher element that s[i] and find the area by 
        # index of large element - s[i]-1 * s[i] - sum(elements between i and large elements)
        # next if highest elemet is in middle then after the highest element find next highest element and calculate area
        i = 0
        s= height
        area = 0
        if len(height) < 3:
            return 0
        while(i<len(s)-1):
            for j in range(i+1,len(s)):
                if s[i] <= s[j]:
                    area += (j-i-1)*s[i] - sum(s[i+1:j])
                    print(area,i,j,s[i],s[j],sum(s[i+1:j]))
                    i=j-1
                    break
            if j == len(s)-1:
                mx =  s[i+1:].index(max(s[i+1:]))
                area += max(s[i+1:])*(mx) - sum(s[i+1:i+1+mx])
                i += mx
            i+=1
        return area

    a = trap( [0,1,0,2,1,0,1,3,2,1,2,1])
    print(a)
        