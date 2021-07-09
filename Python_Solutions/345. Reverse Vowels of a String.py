class Solution:
    def reverseVowels(s):
        i = 0
        j = len(s)-1
        v = ('a','e','i','o','u')
        s = list(s)
        while(i<j):
            print(s[i],s[j])
            if s[i] in v and s[j] in v:
                s[i],s[j] = s[j],s[i]
                i+=1
                j-=1
            elif s[i] in v and s[j] not in v:
                j-=1
            elif s[i] not in v and s[j] in v:
                i+=1
            elif s[i] not in v and s[j] not in v:
                i+=1
                j-=1
        return ''.join(s)
        

    a = reverseVowels("hello")
    print(a)