from typing import List
from collections import deque

# 12 minutes. Accepted first try

# I was trying to be clever with a list comprehension inside of a list comprehension
# Wasted 8 minutes. Just brute forcing easy works. Come back and SOLVE LIST COMPRE TODO
class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:
        """ """

        # sub_arrays = [ [nums[i+j] for j in range(n)] for i in []]  # overly complicated


        sub_arrays = [ [] for _ in range(n)]
        # print(sub_arrays)

        nums_copy = deque(nums[:])

        while len(nums_copy) > 0:
            for i in range(n):
                popped = nums_copy.popleft()
                sub_arrays[i].append(popped)
        
        # print(sub_arrays)


        ans = []
        for sub in sub_arrays:
            ans += sub
        # print(ans)
        return ans


a = Solution()
# a.shuffle([2,5,1,3,4,7], 3)
# a.shuffle([1,2,3,4,4,3,2,1],4)
a.shuffle([1,1,2,2],2)