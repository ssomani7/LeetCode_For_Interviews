class Solution:
    def subdomainVisits(cpdomains):
        dic = {}
        out = []
        for i in range(len(cpdomains)):
            s = cpdomains[i].split(' ')
            temp = ""
            j = len(s[1])-1
            while(j > -1):
                if s[1][j] == "." or j == 0:
                    if s[1][j] == ".":
                        temp = ''.join(str(x) for x in s[1][j+1:])
                    else:
                        temp = ''.join(str(x) for x in s[1][j:])
                    print(temp)
                    if temp not in dic:
                        dic[temp] = int(s[0])
                    else:
                        dic[temp] += int(s[0])
                j-=1
            
        for each in dic:
            out.append(str(dic[each])+" "+str(each))
        return out
        


    a = subdomainVisits(["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"])
    print(a)
        