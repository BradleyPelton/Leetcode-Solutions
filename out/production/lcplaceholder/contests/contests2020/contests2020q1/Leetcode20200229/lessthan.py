from typing import List
class contests2020q4.leetcode20201017.Solution:
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



a = contests2020q4.leetcode20201017.Solution()
a.smallerNumbersThanCurrent([8,1,2,2,3])