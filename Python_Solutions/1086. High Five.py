class Solution:
    def highFive(items):
        import heapq
        count = {}
        for x in items:
            if count.get(x[0]) is None:
                count[x[0]] = []
                heapq.heappush(count[x[0]], x[1])
            else:
                if len(count[x[0]]) < 5:
                    heapq.heappush(count[x[0]], x[1])
                else:
                    heapq.heappushpop(count[x[0]], x[1])
        return [[key, sum(count[key]) // 5] for key in count]
    a = highFive([[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]])
    print(a)