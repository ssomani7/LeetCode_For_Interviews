class Solution:
    def removeInvalidParentheses(s):
        s = list(s)
        out = []
        out.append(("",-1))
        i = 0 
        for i in range(len(s)):
            if s[i] == "(":
                out.append(("(",i))
            elif s[i] == ")":
                if out[-1][0] == "(":
                    out.pop()
                else:
                    out.append((")",i))
        if len(out) > 1:
            count = 0
            for each in out:
                if each[0] != "":
                    del s[each[1]-count]
                    count += 1
        return s

    a = removeInvalidParentheses( "()())()")
    print(a)