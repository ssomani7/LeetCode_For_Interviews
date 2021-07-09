class Solution:
    def reverseWords(s):
        """
        Do not return anything, modify s in-place instead.
        """
        s.append(" ")
        i = 0
        print(s)
        for j in range(len(s)-1):
            print(j)
            if s[j+1] == " ":
                k = j-1
                while(i<k):
                    s[i],s[k] = s[k],s[i]
                    i+=1
                    k-=1
                i = j+1
        return s
    a = reverseWords(["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"])
    print(a)