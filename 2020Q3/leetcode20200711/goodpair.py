from typing import List

# ACcepted after 3 minutes. Childs play

class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        num_of_good_pairs = 0


        for i in range(len(nums)):
            for j in range(i, len(nums)):
                if nums[i] == nums[j] and i < j:
                    print(i,j)
                    num_of_good_pairs += 1

        print(num_of_good_pairs)
        return num_of_good_pairs


a = Solution()
a.numIdenticalPairs([1,2,3,1,1,3])
a.numIdenticalPairs([1,1,1,1])
a.numIdenticalPairs([1,2,3])