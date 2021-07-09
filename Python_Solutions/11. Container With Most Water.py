class Solution:
    def maxArea(height):
        # taking i as one pointer at beginning  and j as another from end point 
        # maxHeight = min(A[i],A[j])*(j-i)
        # while i<j
        # if A[i] < A[j] ? i++ : j--;
        maxHeight = 0
        A = height
        h = len(height)
        i=0
        j=h-1
        while(i <  0):
            temp = (j-i)*min(A[i],A[j])
            if maxHeight < temp:
                maxHeight = temp
            if A[i] < A[j]:
                i+=1
            else :
                j-=1
            print(temp,maxHeight)
        print(maxHeight)
    a = maxArea( [2,3,4,5,18,17,6])
    print(a)