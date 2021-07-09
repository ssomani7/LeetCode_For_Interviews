class Solution:
    def titleToNumber(s):

        import string
        out = {i:c for c,i in enumerate(string.ascii_uppercase)}
        s = s[::-1]
        sm = 0
        for i in range(len(s)):
            if i != 0:
                print(out[s[i]]+1)
                sm += (out[s[i]]+1)*(26**i)
            else:
                sm += (out[s[i]]+1)
        return sm
    a = titleToNumber("AAA")
    print(a)