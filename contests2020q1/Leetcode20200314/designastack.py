
# accepted after second attempt. Minor syntax problem with list comprehension
class CustomStack:
    def __init__(self, maxSize: int):
        self.stack = []
        self.maxSize = maxSize

    def push(self, x: int) -> None:
        if len(self.stack) < self.maxSize:
            self.stack.append(x)
        

    def pop(self) -> int:
        if len(self.stack) == 0:
            return(-1)
        else:
            return self.stack.pop()

    def increment(self, k: int, val: int) -> None:
        self.stack = [self.stack[i]+val if i<k else self.stack[i] for i in range(len(self.stack))]
        
a = CustomStack(3)
a.push(1)
a.push(2)
# print(a.stack)
print(a.pop())
# print(a.stack)
a.push(2)
a.push(3)
a.push(4)
a.increment(5,100)
print(a.stack)
a.increment(2,100)
print(a.stack)

# a = CustomStack(100)
# a.push(1)
# a.push(2)
# a.push(3)
# a.push(5)
# a.push(6)
# a.push(7)
# a.push(8)
# a.push(9)
# print(a.stack)
# a.increment(5,100)
# print(a.stack)