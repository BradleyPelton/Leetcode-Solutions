from typing import List
from collections import Counter
class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        
        copy = arr[:]
        copy = list(set(copy))
        copy.sort()

        
