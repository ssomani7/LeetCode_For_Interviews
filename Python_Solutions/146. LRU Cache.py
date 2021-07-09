class Node(object):
    def __init__(self):
        self.key = 0
        self.val = 0
        self.next = None
        self.prev = None

class LRUCache:
    def __init__(self, capacity: int):
        self.cache = dict()
        self.capacity = capacity
        
        self.head = Node()
        self.tail = Node()
        self.head.next = self.tail
        self.tail.prev = self.head
    
    def remove(self, node: Node):
        node.prev.next = node.next
        node.next.prev = node.prev

    def add(self, node: Node):
        node.next = self.head.next
        node.prev = self.head
        self.head.next = node
        node.next.prev = node
    
        self.cache[node.key] = node
        if len(self.cache) > self.capacity:
            del self.cache[self.tail.prev.key]
            self.remove(self.tail.prev)
    
    def get(self, key: int) -> int:
        if key in self.cache:
            node = self.cache[key]
            self.remove(node)
            self.add(node)
            return node.val
        else:
            return -1

    def put(self, key: int, value: int) -> None:
        newNode = Node()
        newNode.key = key
        newNode.val = value
        if key not in self.cache:
            self.add(newNode)
        else:
            self.remove(self.cache[key])
            self.add(newNode)
            


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)