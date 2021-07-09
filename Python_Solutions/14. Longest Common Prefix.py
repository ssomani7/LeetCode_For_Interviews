class Solution:
    def longestCommonPrefix(strs):
        out = ""
        strs.sort(key=len)
        i = 0
        for each in strs[0]:
            check =0 
            for each1 in strs:
                print(each, each1, i)
                if each[i] == each1[i]:
                    check = 1
                else:
                    check = 0
            i+=1
            if check == 1:
                out = out + each1[i]
    longestCommonPrefix(["flower","flow","flight"])