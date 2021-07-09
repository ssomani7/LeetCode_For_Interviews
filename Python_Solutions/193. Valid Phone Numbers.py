class Solution:
    def numJewelsInStones(J,S):
        cnt = 0
        for each in J:
            cnt = cnt + S.count(each)
        print(cnt)
    numJewelsInStones("aA","aAAbbbb")