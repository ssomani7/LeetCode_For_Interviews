class Solution:
    def isAlienSorted(words, order):
        order_index = {c: i for i, c in enumerate(order)}
        for i in range(len(words)-1):
            word1 = words[i]
            word2 = words[i+1]
            print(word1,word2)
            check = 0
            for j in range(min(len(word1),len(word2))):
                print(word2[j],order_index[word2[j]], word1[j],order_index[word1[j]])
                if order_index[word2[j]] > order_index[word1[j]]:
                    break
                elif  order_index[word2[j]] == order_index[word1[j]] :
                    continue
                else:
                    print("False")
            
        print("tru")

    isAlienSorted(["word","world","row"],"worldabcefghijkmnpqstuvxyz")