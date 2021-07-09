class Solution:
    def isHappy(n):
        al = []
        while(n!=1):
            out = 0
            if n not in al:
                al.append(n)
                for each in str(n):
                    out = out + int(each)*int(each)
                n = out
                continue
            else:
                return False
        return True
        
    print(isHappy(19))