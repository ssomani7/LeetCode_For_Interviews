class Solution:
    def areSentencesSimilar(words1, words2, pairs):
        if abs(len(words1) - len(words2)) > 0:
            return 0 
        for i in range(len(words1)):
            if words1[i] != words2[i]:
                if [words1[i],words2[i]] not in pairs and [words2[i],words1[i]] not in pairs:
                    for j in range(len(pairs)):
                        temp1 = temp2 = ""
                        if words1[i] in pairs[j]:
                            temp1 = list(set(pairs[j]) - set(list(words1[i])))
                        if words2[i] in pairs[j]:
                            temp2 = list(set(pairs[j]) - set(list(words2[i])))
                        if temp1 != temp2 or (temp1 != "" or temp2 != ""):
                            return "No"
                        print(temp1,temp2) 
                else:
                            continue
        return "Yes"  
                        
    a = areSentencesSimilar(["great","acting","skills"],["fine","drama","talent"],[["great","good"],["fine","good"],["drama","acting"],["skills","talent"]])
    print(a)
