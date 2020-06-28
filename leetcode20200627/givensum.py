from typing import List

class Solution:
    def numSubseq(self, nums: List[int], target: int) -> int:
        nums.sort()
        # print(nums)

        i = 0
        j = len(nums) - 1
        # print(nums[i], nums[j])

        number_of_subsequences = 0

        for _ in range(1000):
            # print(f"i is {i}, j is {j}, nums[i] is {nums[i]} and nums[j] is {nums[j]}")
            if nums[i] + nums[j] <= target:
                # print("lessthan")
                # all_arrays = [(i,j)]
                # # Every subsequence between i and j
                # # How many subsequences are there for an array [i+1, ... , j-1]
                # I AND J ALWAYS HAVE TO BE INCLUDED, ANY ELEMENT BETWEEN I AND J CAN OR CANT BE
                number_of_subsequences += 2**(j-i)

                # move i right
                i += 1
            elif nums[i] + nums[j] > target:
                # print("greater than")
                # move j left
                j -= 1

            if i == j or i > j:
                break
        print("--------------")
        print(number_of_subsequences)

        if len(nums) % 2 == 0:
            number_of_subsequences += 1
        return number_of_subsequences

a = Solution()
# a.numSubseq([3,5,6,7], 9)
# a.numSubseq([3,3,6,8], 10)
a.numSubseq([2,3,3,4,6,7], 12)
# a.numSubseq([5,2,4,1,7,6,8], 16)