from typing import List
class Solution:
    def smallerNumbersThanCurrent(self, nums: List[int]) -> List[int]:
        ans = []
        if len(nums) == 1:
            return([0])
        for i in range(len(nums)):
            count = 0
            for j in range(len(nums)):
                if nums[i] > nums[j]:
                    count+= 1
            ans.append(count)
        print(ans)
        return(ans)



a = Solution()
a.smallerNumbersThanCurrent([8,1,2,2,3])