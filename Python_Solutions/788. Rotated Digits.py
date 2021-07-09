class Solution:
    def rotatedDigits(N):


        
        temp = set(["2","5","6","9"])
        count = 0
        for each in range(1,N+1):
            flag = 1
            for each1 in str(each):
                if each1 not in temp:
                    flag = 0
                    break
            if flag == 1: 
                count+=1
            
        return count
    a= rotatedDigits(857)
    print(a)