from typing import List
from collections import Counter
class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        
        copy = arr[:]
        copy = list(set(copy))
        copy.sort()

        c = Counter(arr)

        ans = []
        ans.append()





# a = Solution()
# a.arrayRankTransform([37,12,28,9,100,56,80,5,12])


print(len(b))
print(Counter(b).most_common)