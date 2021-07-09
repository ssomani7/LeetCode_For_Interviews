class Solution:
    def triangleNumber(nums):
        if len(nums) < 3: return 0
        count = 0
        out= []
        nums.sort()
        for i in range(len(nums)-2):
            if nums[i] != 0:
                j = i+1
                k = j+1
                while(k < len(nums)):
                    a,b,c = nums[i],nums[j],nums[k]
                    if a+b > c and c+b > a and a+c > b:
                        out.append([nums[i],nums[j],nums[k]])
                    elif a+b <= c or c+b <= a or a+c <= b:
                        j+=1
                        k+=1
                        break
                    j+=1
                    k+=1
                # for j in range(i+1,len(nums)-1):
                #     if nums[j] != 0:
                #         for k in range(j+1,len(nums)):
                #             if nums[k] != 0:
                #                 a,b,c = nums[i],nums[j],nums[k]
                #                 if a+b > c and c+b > a and a+c > b:
                #                         out.append([nums[i],nums[j],nums[k]])
        return len(out)
        
    a = triangleNumber([1,2,3,4,5,6])
    print(a)