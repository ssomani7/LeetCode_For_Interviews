class Solution:
    def twoSum( nums, target):
        check = 0
        out = []
        sol = []
        for each in nums:
            if(each <= target):
                out.append(each)
        for i in range(len(out)):
            for j in range(i+1, len(out)):
                if out[i] + out[j] == target:
                    sol.append(i)
                    sol.append(j)
                    check = 1
                    break
            if check == 1:
                break
        print(out)
        print(sol)
    twoSum([0,4,3,0],0)