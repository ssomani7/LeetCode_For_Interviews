class Solution:
    def minWindow(s,t):
        if (len(s) < len(t) or len(s) == len(t) == 0 or (len(s) == len(t) == 1 and s!=t)): return ""
        out = []
        dic = {each:-1 for each in t}
        count = s
        out = []
        s += "~"
        for i in range(len(s)):
            if not all(value != -1 for value in dic.values()):
                if s[i] in dic:
                    dic[s[i]] = i
                    out.append(i)
            else:
                start = min(out)
                end = max(out)
                if end -start +1 < len(count):
                    count = s[start:end+1]
                dic = dict.fromkeys(dic, -1)
                out = []

        return "" if all(value != -1 for value in dic.values()) count
        # O(n2)
        # from collections import Counter
        # mxL = len(s)
        # mxV = ""
        # for i in range(len(s)-len(t)+1):
        #     for j in range(i+len(t)-1,len(s)):
        #         if (not Counter(t) - Counter(s[i:j+1])):
        #             if mxL >= len(s[i:j+1]):
        #                 mxL = len(s[i:j+1])
        #                 mxV = s[i:j+1]
        # return mxV

    a = minWindow("ab","a")
    print(a)