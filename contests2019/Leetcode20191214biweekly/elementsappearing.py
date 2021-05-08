from collections import Counter


class contests2020q4.leetcode20201017.Solution:
    def findSpecialInteger(self, arr: List[int]) -> int:
        a = Counter(arr)
        return(a.most_common(1))