class Solution:
    def numSmallerByFrequency(queries,words):
        def smallestEle(s):
            s= sorted(s)
            return s.count(s[0])
        queries = [smallestEle(x) for x in queries]
        words = [smallestEle(x) for x in words]
        i = 0
        out = []
        while(i<len(queries)):
            out.append(len(sorted(k for k in words if k > queries[i])))
            i+=1
        return out
    a = numSmallerByFrequency(["bbb","cc"],["a","aa","aaa","aaaa"])
    print(a)