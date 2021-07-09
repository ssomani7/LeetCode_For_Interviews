class Solution:
    def strongPasswordChecker(s):
        lenFlag, leastFlag, lowerFlag, upperFlag, numFlag, reFlag = 1,1,1,1,1,1
        fl = 0
        if len(s) == 0: return 6
        if len(s) < 6: 
            lenFlag = 1
        elif len(s)  > 20:
            leastFlag = 1
        s = "~~" + s
        i = 2
        while(i<len(s)):
            print(s[i])
            if s[i].isupper(): upperFlag = 0
            if s[i].islower(): lowerFlag = 0
            if s[i].isnumeric(): numFlag = 0
            if s[i] == s[i-1] and s[i] == s[i-2]: fl = 1
            i+=1
        if fl == 0:
            reFlag = 0
        return lenFlag+leastFlag+ lowerFlag+ upperFlag+ numFlag+ reFlag
    a = strongPasswordChecker("aA1")
    print(a)