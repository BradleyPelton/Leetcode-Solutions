from typing import List
from collections import Counter

class Solution:
    def isPossibleDivide(self, nums: List[int], k: int) -> bool:
        nums.sort()


        def isConsecutive(mylist):
            for i in range(1,len(mylist)):
                if mylist[i] != mylist[i-1]+1:
                    return(False)
                return(True)


        if len(nums)%k != 0:
            return(False)
        else:
            parts = [nums[i * k:(i + 1) * k] for i in range((len(nums) + k - 1) // k )]
            print(parts)

            for part in parts:
                if not isConsecutive(part):
                    return(False)

        return(True)




a = Solution()
print(a.isPossibleDivide([3,2,1,2,3,4,3,4,5,9,10,11],3))