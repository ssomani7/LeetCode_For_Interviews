class MaxStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
    global out
    def push(self, x: int) -> None:
        out.insert(x,0)    
    
    def pop(self) -> int:
        out.pop(0)

    def top(self) -> int:
        return out[0]

    def peekMax(self) -> int:
        return max(out)

    def popMax(self) -> int:
        out.remove(max(out))


# Your MaxStack object will be instantiated and called as such:
obj = MaxStack()
obj.push(x)
param_2 = obj.pop()
param_3 = obj.top()
param_4 = obj.peekMax()
param_5 = obj.popMax()