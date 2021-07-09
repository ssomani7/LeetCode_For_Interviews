class Solution:
    def findWords(words):
        dic = {'Q':1,'W':1,'E':1,'R':1,'T':1,'Y':1,'U':1,'I':1,'O':1,'P':1,'A':2,'S':2,'D':2,'F':2,'G':2,'H':2,'J':2,'K':2,'L':2,'Z':3,'X':3,'C':3,'V':3,'B':3,'N':3,'M':3}
        print(words[0])
        return [each for each in words if all(dic[each[i].upper()] == dic[each[i+1].upper()] for i in range(len(each)-1))]
        
    a= findWords(["Hello", "Alaska", "Dad", "Peace"])
    print(a)