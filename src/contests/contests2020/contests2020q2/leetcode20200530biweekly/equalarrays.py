from collections import Counter
from typing import List

# Accepted first try, 5 minutes. Easy peasy
class contests2020q4.leetcode20201017.Solution:
    def canBeEqual(self, target: List[int], arr: List[int]) -> bool:
        tar_counter = Counter(target)
        arr_counter = Counter(arr)

        for k in tar_counter.keys():
            if tar_counter[k] == arr_counter[k]:
                pass
            else:
                return False
        return True

a = contests2020q4.leetcode20201017.Solution()
print(a.canBeEqual([1,2,3,4], [2,4,1,3]))
print(a.canBeEqual([3,7,9],[3,7,11]))