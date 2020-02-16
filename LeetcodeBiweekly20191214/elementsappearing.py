from collections import Counter


class Solution:
    def findSpecialInteger(self, arr: List[int]) -> int:
        a = Counter(arr)
        return(a.most_common(1))