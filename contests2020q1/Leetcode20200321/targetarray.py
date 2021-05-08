from typing import List
# poorly worded question 
# iterate over nums 
class contests2020q4.leetcode20201017.Solution:
    def createTargetArray(self, nums: List[int], index: List[int]) -> List[int]:
        
        """From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array"""

        target_array = []
        # print(nums)
        # print(index)
        # for i in range(len(index)):
        #     print(index[i], nums[index[i]])
        #     # target_array.insert(index[i], nums[index[i]])
        # print(target_array)

        for i in range(len(nums)):
            target_array.insert(index[i], nums[i])
        print(target_array)
        return(target_array)


a = contests2020q4.leetcode20201017.Solution()
# a.createTargetArray([0,1,2,3,4],[0,1,2,2,1])
# a.createTargetArray([1,2,3,4,0], [0,1,2,3,0])
a.createTargetArray( [1],[0])