class Solution:
    def shortestCompletingWord(licensePlate,words):
        from collections import Counter
        dic = {}
        for each in licensePlate:
            if not each.isalpha():
                continue
            if each.lower() not in dic:
                dic[each.lower()] = 1
            else:
                dic[each.lower()] += 1
        print(dic)

        for i in range():
            
        # maxL = 0
        # flag = 0
        # for each in words:
        #     print(set(Counter(each).keys()))
        #     print(set(dic))
            
        #     if set(Counter(each).keys()).issubset(set(dic)):
        #         each = Counter(each)
        #         for each1 in dic:
        #             print(each,each1)
        #             if dic[each1] >  each[each1]:
        #                 flag = 1
        #                 break
        #         if flag ==0 : maxL = max(maxL,len(each1))
        #         flag = 0
        # return maxL

    a = shortestCompletingWord("1s3 PSt",["step", "steps", "stripe", "stepple"])
    print(a)