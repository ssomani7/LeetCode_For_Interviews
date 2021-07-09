class Solution(object):
    def numRookCaptures(board):
        """
        :type board: List[List[str]]
        :rtype: int
        """
        counter = upFlag = downFlag = leftFlag = rightFlag = x = y = i = a = b = c = d = 0
        for i in range(len(board)):
            if "R" in board[i]:
                x=i 
                y= board[i].index('R')
        print(x,y)

        def check():

        #def check()
        while(1):
            if upFlag == 0:
                counter += (check()) 


        # captures = 0
        # x = y=0
        # for i in range(len(board)):
        #     if "R" in board[i]:
        #         x=i 
        #         y= board[i].index('R')
        # temp = 0
        # for each in board[x][y+1:]: # hr ->
        #     if "." in each:
        #         continue
        #     elif each.islower():
        #         temp+=1
        #         break
        #     elif not each.islower():
        #         break
        # print(temp)
        # st = (board[x][:y])
        # st.reverse()
        # for each in st: # <- hr
        #     if "." in each:
        #         continue
        #     elif each.islower():
        #         temp+=1
        #         break
        #     elif not each.islower():
        #         break
        # print(temp)
        # i = x-1
        # while(i>=0):
        #     if "." in board[i][y]:
        #         i-=1
        #     elif board[i][y].islower():
        #         print(board[i][y])
        #         temp+=1
        #         break
        #     elif not board[i][y].islower():
        #         break
        # print(temp)
        # for i in range(x+1,len(board)): # downwards
        #     if "." in board[i][y]:
        #         continue
        #     elif board[i][y].islower():
        #         temp+=1
        #         break
        #     elif not board[i][y].islower():
        #         break
        # print(temp)
    a = numRookCaptures([[".",".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".","p","p","B","p","p",".","."],[".","p","B","R","B","p",".","."],[".","p","p","B","p","p",".","."],[".","p","p","p","p","p",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]])
    print(a)
        