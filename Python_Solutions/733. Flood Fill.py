class Solution:
    def floodFill(p, x, y, n):
    	M, N, c = len(p), len(p[0]), p[x][y]
    	if n == c: return p
    	def dfs(i,j):
    		if p[i][j] == c:
    			p[i][j] = n
    			for a in [[i-1,j],[i,j+1],[i+1,j],[i,j-1]]:
    				if not (a[0] in [-1,M] or a[1] in [-1,N]): dfs(a[0],a[1])
    	dfs(x,y)
    	return p
    a= floodFill([[1,1,1],[1,1,0],[1,0,1]],1,1,2)
    print(a)