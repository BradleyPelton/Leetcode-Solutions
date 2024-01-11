from typing import List
# Accepted first attempt after 9 minutes. Not the prettiest of solutions but it works
class contests2020q4.leetcode20201017.Solution:
    def kLengthApart(self, nums: List[int], k: int) -> bool:
        """ """

        index_list = []
        for i in range(len(nums)):
            if nums[i] == 1:
                index_list.append(i)
        print(index_list)

        for j in range(len(index_list)-1):
            if index_list[j+1] - index_list[j] < k+1:
                print(f"found a problem with indexes {index_list[j], index_list[j+1]}")
                print(False)
                return(False)
        print(True)
        return(True)


a = contests2020q4.leetcode20201017.Solution()
# a.kLengthApart([1,0,0,0,1,0,0,1],2)
# a.kLengthApart([1,0,0,1,0,1],2)
# a.kLengthApart([1,1,1,1,1],0)
a.kLengthApart([0,1,0,1],1)
