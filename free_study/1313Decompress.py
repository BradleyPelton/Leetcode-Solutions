from typing import List


## Accepted after first attempt

class contests2020q4.leetcode20201017.Solution:
    def decompressRLElist(self, nums: List[int]) -> List[int]:
        """ """
        deco_list = []

        for i in range(0,len(nums),2):
            deco_list.extend([nums[i+1] for _ in range(nums[i])])
            # print(deco_list)
        
        return deco_list

a = contests2020q4.leetcode20201017.Solution()
a.decompressRLElist([1,2,3,4])
a.decompressRLElist([1,1,2,3])