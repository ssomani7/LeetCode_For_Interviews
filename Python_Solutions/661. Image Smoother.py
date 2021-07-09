class Solution:
    def imageSmoother(M):
        M = M
        R = len(M)
        C = len(M[0])
        if R==1 and C==1:
            return M
        else:
            # empty matrix
            ans = [[0]*C for _ in range(R)]
            for i in range(1,R-1):
                for j in range(1,C-1):
                    ans[i][j] = (M[i-1][j-1] + M[i-1][j] + M[i-1][j+1] + 
                                 M[i][j-1] + M[i][j] + M[i][j+1] +
                                 M[i+1][j-1] + M[i+1][j] + M[i+1][j+1])//9

            for i in [0,R-1]:
                if i == 0:
                    i2 = 1
                else:
                    i2 = R-2
                for j in range(1,C-1):
                    ans[i][j] = (M[i][j-1] + M[i][j] + M[i][j+1] +
                                    M[i2][j-1] + M[i2][j] + M[i2][j+1])//6
                ans[i][0] = (M[i][0] + M[i][1] + M[i2][0] + M[i2][1])//4
                ans[i][C-1] = (M[i][C-2] + M[i][C-1] + M[i2][C-2] + M[i2][C-1])//4
            for j in [0,C-1]:
                if j == 0:
                    j2 = 1
                else:
                    j2 = C-2
                for i in range(1,R-1):
                    ans[i][j] = (M[i-1][j] + M[i][j] + M[i+1][j] +
                                    M[i-1][j2] + M[i][j2] + M[i+1][j2])//6
                ans[0][j] = (M[0][j] + M[1][j] + M[0][j2] + M[1][j2])//4
                ans[R-1][j] = (M[R-2][j] + M[R-1][j] + M[R-2][j2] + M[R-1][j2])//4
            return ans
    a = imageSmoother([[2,3,4],[5,6,7],[8,9,10],[11,12,13],[14,15,16]])
    print(a)