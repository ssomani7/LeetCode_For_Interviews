class Solution:
    def largeGroupPositions(S):
        # "abcdddeeeeeeeeeeeeeeaabbbcd"
        i=0
        j = 1
        count = 0
        out = []
        if len(S) < 3:
            return []
        while(i<len(S)-1):
            if S[i] == S[j]:
                count+=1
                j+=1

            else:
                if count >= 2:
                    out.append([i,j-1])
                count = 0
                i = j
                j+=1  
            if j == len(S):
                if count >= 2:
                    out.append([i,j-1])
                return out
        return out
        # only 10% eff.
        # out = []
        # i = 0
        # while(i < len(S)):
        #     j = i+1
        #     count = 0
        #     while(j<len(S)):
        #         print(S[i],S[j])
        #         if S[i] == S[j]:
        #             count += 1
        #         else:
        #             break
        #         j+=1
        #     if count >= 2:
        #         out.append([i,j-1])
        #         i = j
        #     else:
        #         i+=1
            
        # return out

    a = largeGroupPositions("aaa")
    print(a)