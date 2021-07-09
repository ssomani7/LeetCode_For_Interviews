class Solution:
    def threeSumClosest(nums,target):
        nums.sort()


        # out = []
        # maxS = 10000
        # ans  = 0
        # for i in range(len(nums)):
        #     for j in range(i+1,len(nums)):
        #         for k in range(j+1,len(nums)):
        #             # out.append(target-(nums[i]+nums[i]+nums[i]))
        #             if maxS > abs(target-(nums[i]+nums[j]+nums[k])):
        #                 maxS = abs(target-(nums[i]+nums[j]+nums[k]))
        #                 ans = abs(nums[i]+nums[j]+nums[k])
        # return ans

    a = threeSumClosest([-1, 2, 1, -4],1)
    print(a)