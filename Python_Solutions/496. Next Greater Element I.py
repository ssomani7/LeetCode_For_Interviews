class Solution:
    def nextGreaterElement(nums1,nums2):
        out =[]
        for each in nums1:
            if len(nums2) != nums2.index(each)+1 and max(nums2[nums2.index(each)+1:]) > each:
                out.append([ch for ch in nums2[nums2.index(each)+1:] if ch > each][0])
            else:
                out.append(-1)
        return out
    a = nextGreaterElement([4,1,2],[1,3,4,2])
    print(a)