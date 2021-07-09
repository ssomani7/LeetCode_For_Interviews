class Solution:
    def shortestDistance(words, word1, word2):
        minDistance = final = -1
        while(1):
            val1 = val2 = -1
            if word1 in words:
                firstHalf = words [:words.index(word1)+1]
                firstHalf.reverse()
                secondHalf = words [words.index(word1):]
                print(firstHalf)
                print(secondHalf)
                if word2 in firstHalf:
                        val1 = abs(firstHalf.index(word1)- firstHalf.index(word2))
                if word2 in secondHalf:
                        val2 = abs(secondHalf.index(word1)- secondHalf.index(word2))
                        print(val2)
                if val2 != -1 and val1 != -1:
                    minDistance = (val1 if val1 < val2 else val2)
                else:
                    minDistance = (val1 if val1 != -1 else val2)
                words.remove(word1)
                final = (final if final < minDistance and final !=-1 else minDistance)
            else:
                print(final)
                break
    shortestDistance(["this","is","a","long","sentence","is","fun","day","today","sunny","weather","is","a","day","tuesday","this","sentence","run","running","rainy"],"this","is",)