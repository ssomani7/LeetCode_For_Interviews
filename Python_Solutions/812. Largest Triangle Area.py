class Solution:
    def largestTriangleArea(points):
        out = 0
        x = [ each for each in points if each[1] == 0 and each[0] != 0]
        y = [ each for each in points if each[0] == 0 and each[1] != 0]
        return ''.join([x if x == "." else x for x in address])
        maxA = 0
        import math
        for i in range(len(x)):
            for j in range(len(y)):
                a = x[i][0]
                b = y[j][1]
                c = math.sqrt((a**2+b**2))
                per = round((a+b+c)/2,2)
                area = round(math.sqrt((per*(abs(per-a))*(abs(per-b))*(abs(per-c)))),2)
                maxA = max(maxA,area)
                
        return round(maxA)


    a= largestTriangleArea([[1,0],[0,0],[0,1]])
    print(a)