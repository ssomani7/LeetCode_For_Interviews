class MovingAverage:

    def __init__(self, size: int):
        """
        Initialize your data structure here.
        """
        global nex,s
        s = size
        nex = []

    def next(self, val: int) -> float:
        global nex,s
        print(len(nex),s)
        if len(nex) != s:
            nex.append(val)
            return sum(nex)/len(nex)
        else:
            nex.append(val)
            print(nex)
            return sum(nex[-s:])/s
print(sum([-940, -8516, -16446, 7870,25545])/5)

a = [[5],[12009],[1965],[-940],[-8516],[-16446],[7870],[25545],[-21028],[18430],[-23464]]

out = []
obj = MovingAverage(a[0])
for each in a[1:]:
    param_1 = obj.next(each[0])
    out.append(param_1)
print(out)
    