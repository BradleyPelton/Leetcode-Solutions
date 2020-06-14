

from typing import List

# solved first ttempt in 2 minutes. childs play
class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        """ """
        current_sum = 0
        ans = []

        for num in nums:
            current_sum += num
            ans.append(current_sum)

        # print(ans)
        return ans

a = Solution()
a.runningSum([1,2,3,4])
a.runningSum([1,1,1,1,1])
a.runningSum([3,1,2,10,1])