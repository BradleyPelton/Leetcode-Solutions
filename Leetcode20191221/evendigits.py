from typing import List
class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        new_list = [x for x in nums if len(str(x))%2 == 0]
        return(len(new_list))




a = Solution()
print(a.findNumbers([12,345,2,6,7896]))
print(a.findNumbers([555,901,482,1771]))