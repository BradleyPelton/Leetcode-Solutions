from collections import deque

# First attempt rejected, index error
# SEcond attempt rejected, wrong answer
# Third attempt accepted, I forgot to update current index in overflow case

class BrowserHistory:

    def __init__(self, homepage: str):
        self.history_deq = deque()
        self.current_index = 0

        # Homepage is always the first element in the deque
        self.history_deq.append(homepage)

    def visit(self, url: str) -> None:
        # If we are already at the latest page, just append right
        if self.current_index == len(self.history_deq) - 1:
            self.history_deq.append(url)
            self.current_index += 1
        else:
            # Truncate the remaining elements
            self.history_deq = deque(list(self.history_deq)[:self.current_index + 1])

            self.history_deq.append(url)
            self.current_index += 1

    def back(self, steps: int) -> str:
        # Can't go further back than home
        if self.current_index - steps < 0:
            self.current_index = 0
            return self.history_deq[self.current_index]
        else:
            self.current_index -= steps
            return self.history_deq[self.current_index]

    def forward(self, steps: int) -> str:
        # Can't go further than furthest point
        if self.current_index + steps > len(self.history_deq) - 1:
            self.current_index = len(self.history_deq) - 1
            furthest = self.history_deq[-1]
            return furthest
        else:
            self.current_index += steps
            furthest = self.history_deq[self.current_index]
            return furthest


# Your BrowserHistory object will be instantiated and called as such:
# obj = BrowserHistory('leetcode.com')
# obj.visit('google.com')
# obj.visit('facebook.com')
# obj.visit('youtube.com')
# # print(obj.history_deq)
# print(obj.back(1))
# print(obj.back(1))
# print(obj.forward(1))
# print("LINKEDINADDING")
# obj.visit('linkedin.com')
# print(obj.forward(2))
# print(obj.back(2))
# print(obj.back(7))

obj = BrowserHistory('a.com')
obj.visit('b.com')
obj.visit('c.com')
obj.visit('d.com')
obj.visit('e.com')
obj.visit('f.com')
obj.visit('g.com')
print(obj.back(3))
obj.visit('after.com')
print(obj.history_deq)
print(obj.forward(5))
