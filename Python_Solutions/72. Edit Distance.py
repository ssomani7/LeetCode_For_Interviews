class Solution:
    def minDistance(word1, word2):
        count = abs(len(word1) - len(word2))
        word1 = [each for each in word2]
        for each in word2:
            if each in word1:
                word1.remove(each)
                count+=1
            print(word1)
        count+= len(word1)
        return count
    a = minDistance("horse","ros")
    print(a)