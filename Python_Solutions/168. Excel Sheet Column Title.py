class Solution:
    def convertToTitle(n):
        dic = {i+1:c for i,c in enumerate([chr(i) for i in range(ord('A'),ord('Z')+1)])}
        if n <= 26: return dic[n]
        ans = ""
        while(n > 26):
            if n%26 != 0:
                ans+= dic[n//26]
            else:
                ans+= dic[(n//26)-1] + "Z"
            n //= 26
        if n != 0:
            ans+= dic[n]
        return ans
            
    a = convertToTitle(546)
    print(a)