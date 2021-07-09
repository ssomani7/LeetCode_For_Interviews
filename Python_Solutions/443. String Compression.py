class Solution:
    def compress(chars):
        from collections import Counter
        a = list(Counter(chars).items())
        b = [[x for x in each] for each in a]
        b = [q for q in [each for each in a]]
        return b
    c = compress(["a","a","b","b","c","c","c"])
    print(c)