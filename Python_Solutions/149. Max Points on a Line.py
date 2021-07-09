class Solution:
    def maxPoints(points):
        if len(points) in (0,1):
            return len(points)
        elif len(points) == 2:
            return 2
        dic = {}
        pnts = {}
        for i in range(len(points)):
            for j in range(i+1,len(points)):
                if points[j][0] - points[i][0] != 0:
                    if not (str(points[i]) in pnts and str(points[j]) in pnts):
                        pnts[str(points[i])] = 1
                        pnts[str(points[j])] = 1
                        m = (points[j][1] - points[i][1])/(points[j][0] - points[i][0])
                        if m != 0:
                            if m not in dic:  
                                dic[m] = 2
                            else:
                                dic[m]+=1
        print(dic)
        
    a = maxPoints(  [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]])
    print(a)