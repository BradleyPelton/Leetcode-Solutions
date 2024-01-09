from typing import List

# Solved in 90 seconds. Easy peasy
class contests2020q4.leetcode20201017.Solution:
    def maxProduct(self, nums: List[int]) -> int:
        """ """

        nums.sort()

        a = nums[-1]
        b = nums[-2]

        print((a-1)*(b-1))
        return (a-1)*(b-1)


a = contests2020q4.leetcode20201017.Solution()
a.maxProduct([3,4,5,2])
a.maxProduct([1,5,4,5])