from typing import List


### Accepted after 14 minutes. This is a nasty brute force problem, but len(nums) <100 so I can
### I wonder what the optimal solution would be. Something about hand picking the sub arrays created
### No reason to create the sub arrays that arent being counted.



class contests2020q4.leetcode20201017.Solution:
    def rangeSum(self, nums: List[int], n: int, left: int, right: int) -> int:
        """ """

        L = nums
        all_sub_sums = [sum(L[i:i+j]) for i in range(0,len(L)) for j in range(1,len(L)-i+1)]
        all_sub_sums.sort()
        # print(all_sub_sums)

        ans = sum(all_sub_sums[left-1:right])
        # print(ans)

        return ans % (10**9 + 7)

a = contests2020q4.leetcode20201017.Solution()
a.rangeSum(nums = [1,2,3,4], n = 4, left = 1, right = 5)
a.rangeSum(nums = [1,2,3,4], n = 4, left = 3, right = 4)
a.rangeSum(nums = [1,2,3,4], n = 4, left = 1, right = 10)