class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        
        maxRows = len(grid)
        maxCols = len(grid[0])
        count = 0
        
        def dfs(r,c):
            if r >= maxRows or c >= maxCols or r < 0 or c < 0 or grid[r][c] == "0":
                return
            
            grid[r][c] = "0"
            
            dfs(r+1,c)
            dfs(r,c+1)
            dfs(r-1,c)
            dfs(r,c-1)
            return
        
        for r in range(maxRows):
            for c in range(maxCols):
                if grid[r][c] == '1':
                    count+=1
                    dfs(r,c)
        return count