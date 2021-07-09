class Solution:
    def duplicateZeros(arr):
        """
        Do not return anything, modify arr in-place instead.
        """
        i = 0
        while(i < len(arr)):
            print(i)
            arr[i]
            if arr[i] == 0:
                arr.insert(i,0)
                arr.pop()
                i+=1
            i+=1
        print(arr)
    duplicateZeros([0,4,1,0,0,8,0,0,3])