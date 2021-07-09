class Solution(object):
    def countCharacters(words, chars):
        """
        :type words: List[str]
        :type chars: str
        :rtype: int
        """
        from collections import Counter

        sumOfN = 0
        chars = Counter(chars)
        for each in words:
            out = 0
            for each1 in each:
                temp = Counter(each)
                if each1 in chars and temp[each1] <= chars[each1]:
                    out = out + 1
                else:
                    out = 0
                    break
            sumOfN = sumOfN + out
        return sumOfN
            
    a = countCharacters(["hello","world","leetcode"],"welldonehoneyr")
    print(a)