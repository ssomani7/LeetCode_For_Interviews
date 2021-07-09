class Solution(object):
    def minimumAbsDifference(arr):
        """
        :type arr: List[int]
        :rtype: List[List[int]]
        """
        arr.sort()
        minDiff = max(arr) + 1
        out = []
        for i in range(len(arr)-1):
            if (arr[i+1] - arr[i]) < minDiff:
                minDiff = arr[i+1] - arr[i] 
        for i in range(len(arr)-1):
            if arr[i+1] - arr[i] == minDiff:
                out.append([arr[i],arr[i+1]])
        return out
    a= minimumAbsDifference([4,2,1,3])
    print(a)