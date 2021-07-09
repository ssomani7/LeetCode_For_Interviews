class Solution:
    def checkStraightLine(coordinates):
        for i in range(2,len(coordinates)):
            if coordinates[i][1] * (coordinates[1][0]-coordinates[0][0]) != coordinates[i][0]*(coordinates[1][1]-coordinates[0][1]) + coordinates[1][0]*coordinates[0][1]-coordinates[0][0]*coordinates[1][1]:   
                return False
        return True 

    a = checkStraightLine([[-1,1],[-6,-4],[-6,2],[2,0],[-1,-2],[0,-4]])
    print(a)
        