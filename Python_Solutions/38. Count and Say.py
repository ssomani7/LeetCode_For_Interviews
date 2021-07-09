class Solution:
    def countAndSay(n):
        if n == 1:
            return "1" 
        
        def elCount(num):
            s = ""
            i= 0 
            while(i<len(num)):
                count = 1
                temp  = num[i]
                for j in range(i+1,len(num)):
                    if num[j] == num[i]:
                        count +=1
                        i+=1
                    else:
                        break
                s += str(count) + temp
                i+=1
            return s
                    
        out = []
        out.append("1")
        for i in range(1,n):
            a = elCount(out[i-1])
            out.append(str(a))
        return out[n-1]
        
    a = countAndSay(10)
    print(a)