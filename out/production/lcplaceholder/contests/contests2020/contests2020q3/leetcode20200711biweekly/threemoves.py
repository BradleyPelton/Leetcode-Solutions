from typing import List

from collections import Counter

class contests2020q4.leetcode20201017.Solution:
    def minDifference(self, nums: List[int]) -> int:
        """ """

        nums.sort()
        print(nums)

        global_min = min(nums)
        global_max = max(nums)

        # print(global_min, global_max)

        # Theory: We always move all three moves up or all three moves down, never a mix

        num_count = dict(Counter(nums))
        num_tuples = [(k,v) for k,v in num_count.items()]

        # print(num_tuples)

        # smallest_four = nums[0:4]
        # greatest_four = nums[-4:]
        # print(smallest_four, greatest_four)

        ### one element in the smallest four and greatest four will have to stay the same




        ### ALTERNATIVELY- just brute force
        # There is no reason to consider changing any number that occurs more than 3 times
        potential_nums_to_change = [tup for tup in num_tuples if tup[1] <= 3]
        # print(potential_nums_to_change)


        current_nums = [num for num in nums if num != global_max and num != global_min]
        print(current_nums)

        #### ALTERNATIVELY - RELATIVE SUMS
        center = current_nums[3:-3]
        print(center)
        # center_min = center[0]
        # center_max = center[-1]

        # ans_a = global_max - center_min
        # ans_b = global_min - center_max
        # print(ans_a, ans_b)



a = contests2020q4.leetcode20201017.Solution()
# a.minDifference(nums = [1,5,0,10,14])
a.minDifference(nums = [6,6,0,1,1,4,6])
# a.minDifference(nums = list(range(10)))