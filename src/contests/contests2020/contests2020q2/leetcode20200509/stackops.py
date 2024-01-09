from typing import List
from collections import deque

# accepted first try. 15 mintues. Weirdly worded. I didnt know what pushing an array meant.
# Apparently its what other languages use as append. TIL
class contests2020q4.leetcode20201017.Solution:
    def buildArray(self, target: List[int], n: int) -> List[str]:

        # list = [1,2,3,4...., n]
        range_deq = deque(range(1,n+1))
        print(range_deq)

        steps = []
        built = []
        for num in target:
            while True:
                popped = range_deq.popleft()
                print(f"popped is {popped}, num is {num}")
                if popped == num:
                    steps.append("Push")
                    built.append(popped)
                    print(f"found a number, adding {popped}")
                    break
                else:
                    steps.append("Push")
                    steps.append("Pop")

            if built == target:
                print("finished")
                break
        # print(steps)
        return steps

a = contests2020q4.leetcode20201017.Solution()
# a.buildArray([1,3],3)
# a.buildArray([1,2,3],3)
# a.buildArray([1,2],4)
a.buildArray([2,3,4],4)




