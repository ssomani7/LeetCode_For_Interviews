class Solution:
    def isPalindrome(s):
        out = []
        for char in s:
            if char.isalpha():
                out.append(char)
            
        s = ''.join(out)
        if s[::-1].lower() == s.lower():
            print('Yes')
        else:
            print(s[::-1])
            print(s)
    isPalindrome("A man, a plan, a canal: Panama")    