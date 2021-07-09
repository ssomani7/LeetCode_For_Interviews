class Solution:
    def selfDividingNumbers(left,right):

        out = []
        for each in range(left,right+1):
            check = 0
            if "0" in str(each):
                continue
            for each1 in str(each):
                if each % int(each1) != 0:
                    check = 1
                    break
            if check == 0:
               out.append(each) 
        return out
    a = selfDividingNumbers(1,22)
    print(a)