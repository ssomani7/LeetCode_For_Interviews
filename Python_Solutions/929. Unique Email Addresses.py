class Solution:
    def numUniqueEmails(emails):
        dic = []
        for each in emails:
            domain = each[each.index("@"):]
            localName = each[:each.index("@")]
            localName = localName.replace(".","")
            a = localName.find("+")
            if a == -1:
                total = localName + domain
            else:
                total = localName[:a] + domain
            if total not in dic:
                dic.append(total)
        return len(dic)
                
    a = numUniqueEmails(["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"])
    print(a)