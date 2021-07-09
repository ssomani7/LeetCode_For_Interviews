class Solution:
    def deckRevealedIncreasing(deck):
        import collections
        N = len(deck)
        index = collections.deque(range(N))
        ans = [None] * N
        for card in sorted(deck):
            ans[index.popleft()] = card
            if index:
                index.append(index.popleft())

        return ans
    a = deckRevealedIncreasing([17,13,11,2,3,5,7])
    print(a)