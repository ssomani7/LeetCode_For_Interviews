class Solution:
    def dietPlanPerformance(calories, k, lower, upper):
        countUp = 0
        countLow = 0
        for i in range(len(calories)):
            if i<k:
                temp = (calories[:i])
            else:
                temp = (calories[i-k:i])
            if sum(temp) > upper:
                countUp+=1
            elif sum(temp) < lower:
                countLow+=1
            print(temp,countUp,countLow)
        return abs(abs(countUp) - abs(countLow))
        
    a = dietPlanPerformance([1,2,3,4,5],1,3,3)
    print(a)