from collections import Counter
from typing import List

# accepted first try
class contests2020q4.leetcode20201017.Solution:
    def findLucky(self, arr: List[int]) -> int:
        c = dict(Counter(arr))

        lucky_ints = []
        for k,v in c.items():
            if k == v:
                lucky_ints.append(k)

        if not lucky_ints:
            return(-1)
        print(max(lucky_ints))
        return(max(lucky_ints))

a = contests2020q4.leetcode20201017.Solution()
a.findLucky([1,2,2,3,3,3])
a.findLucky([2,2,3,4])
a.findLucky([2,2,2,3,3])