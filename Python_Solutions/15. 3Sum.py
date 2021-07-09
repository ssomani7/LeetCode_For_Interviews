# using sorting method here

class Solution(object):
    def threeSum(arr):
        out = []
        arr.sort()
        for i in range(len(arr)-2):
            l = i+1
            r = len(arr)-1
            while(l<r):
                print( [arr[i],arr[l],arr[r]])
                temp = [arr[i],arr[l],arr[r]]
                temp.sort()
                if temp not in out:
                        if sum(temp) == 0:
                            out.append(temp)
                            l+=1
                            r-=1
                        elif sum(temp) < 0:
                            l+=1
                        else:
                            r-=1
                else:
                    l+=1
                    r-=1
        return out
    a = threeSum([-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6])
    print(a)
#[[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2]]
#[[-4, -2, 6], [-2, -2, 4], [-2, 0, 2]]