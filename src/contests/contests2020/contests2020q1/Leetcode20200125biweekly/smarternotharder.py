from typing import List
from collections import Counter
class contests2020q4.leetcode20201017.Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        
        copy = arr[:]
        copy = list(set(copy))
        copy.sort()

        
