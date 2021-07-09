import collections
class Solution:
    def numPairsDivisibleBy60(self, time: List[int]) -> int:
        rem = collections.defaultdict(int)
        res = 0
        for t in time:
            if t%60 == 0:
                res += rem[0]
            else:
                res += rem[60-(t%60)]
            rem[t%60] += 1
        return res