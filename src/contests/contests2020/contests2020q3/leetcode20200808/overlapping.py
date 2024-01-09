from typing import List
from collections import defaultdict

class contests2020q4.leetcode20201017.Solution:
    def maxNonOverlapping(self, nums: List[int], target: int) -> int:
        """ """

        # famous k-sum sub array problem
        def findSubarraySum(arr, n, Sum):
            prevSum = defaultdict(lambda : 0)
            res = 0
            currsum = 0

            for i in range(0, n):
                currsum += arr[i]
                if currsum == Sum:
                    res += 1
                if (currsum - Sum) in prevSum:
                    res += prevSum[currsum - Sum]
                prevSum[currsum] += 1

            return res

        print(findSubarraySum(nums, len(nums), target))

a = contests2020q4.leetcode20201017.Solution()
a.maxNonOverlapping([-1,3,5,1,4,2,-9], target = 6)
