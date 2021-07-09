class Solution:
    def removeOuterParentheses(S):
        outter = 0
        x = ''

        for i in S:
            if i == '(' and outter > 0:
                x += i
                outter += 1
            if i == ')' and outter > 1:
                x += i
                outter -= 1
            outter += 1 if i == '(' else -1
            
        return x
    a = removeOuterParentheses("(()())(())")
    print(a)