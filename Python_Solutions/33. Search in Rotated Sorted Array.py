class Solution:
    def search(nums,target):
        out = nums
        temp = 0
        while(len(nums)>0):
            n = len(nums)-1
            print(nums)
            print(int((n+1)/2))
            if n%2 ==1 :
                if nums[int((n+1)/2)] == target:
                    return temp + int((n+1)/2)
                elif nums[int((n+1)/2)] > nums[int((n+1)/2)-1]:
                    nums = nums[int((n+1)/2):]
                else:
                    nums = nums[:int((n)/2)]
                temp = temp + int((n+1)/2)
            else:
                if nums[int((n)/2)] == target:
                    return temp + int((n)/2)
                elif nums[int((n)/2)] > nums[int((n)/2)-1]:
                    nums = nums[int((n)/2):]
                else:
                    nums = nums[:int((n)/2)]
                temp = temp + int((n)/2)
    a = search([4,5,6,7,0,1,2],0)
    print(a)