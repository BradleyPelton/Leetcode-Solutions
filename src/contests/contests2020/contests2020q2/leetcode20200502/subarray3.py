from typing import List
# Seems like Dynamic Programming(DP) algorithm could have solved this.
# I need to refresh on these fancy techniques.
# It also seems like this type of problem ALWYAS COMES UP. Namely a problem that is 
# find the largest subarray such that "x condition".

class contests2020q4.leetcode20201017.Solution:
    def longestSubarray(self, nums: List[int], limit: int) -> int:
        """ """
        valid_array_lengths = []

        for i in range(len(nums)):
            ith_subarray_length = 1
            ith_smallest = nums[i]
            ith_largest = nums[i]
            current_index = i
            while current_index < len(nums) - 1:
                current_index += 1

                if nums[current_index] <= ith_largest and nums[current_index] >= ith_smallest:
                    ith_subarray_length += 1
                else:
                    if abs(ith_smallest - nums[current_index]) <= limit:
                        if abs(ith_largest - nums[current_index]) <= limit:
                            ith_subarray_length += 1
                            # UPDATING THE BOUNDS OF ACCEPTABILITY
                            if nums[current_index] < ith_smallest:
                                ith_smallest = nums[current_index]
                            if nums[current_index] > ith_largest:
                                ith_largest = nums[current_index]
                        else:
                            break
                    else:
                        break
            valid_array_lengths.append(ith_subarray_length)

        print(max(valid_array_lengths))
        return(max(valid_array_lengths))


a = contests2020q4.leetcode20201017.Solution()
# a.longestSubarray([8, 2, 4, 7], 4)
# a.longestSubarray([10,1,2,4,7,2], 5)
# a.longestSubarray([4,2,2,2,4,4,2,2], 0)
a.longestSubarray([4,8,5,1,7,9], 6)