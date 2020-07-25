from typing import List

# first attempt - brute force- timed out (generate all subarrays)
# Second attempt- semi brute force - timed out
# THird attempt - ignoring sums and just using remainders - timed out

class Solution:
    def numOfSubarrays(self, arr: List[int]) -> int:
        """ """

        total_count = 0

        remainder_arr = [obj%2 for obj in arr]
        # print(remainder_arr)

        # for i in range(len(arr)):
        #     # print(f"i is {i}")
        #     current_remainder = remainder_arr[i]

        #     if current_remainder == 1:
        #         total_count += 1

        #     for j in range(i+1, len(arr)):
        #         # print(f"j is {j}")
        #         if remainder_arr[j] == 1:
        #             if current_remainder == 0:
        #                 total_count += 1
        #                 current_remainder = 1
        #             elif current_remainder == 1:
        #                 current_remainder = 0

        #         elif remainder_arr[j] == 0:
        #             if current_remainder == 0:
        #                 current_remainder = 0
        #             elif current_remainder == 1:
        #                 total_count += 1
        #                 current_remainder = 1

        print(total_count)
        return total_count



a = Solution()
# a.numOfSubarrays([1,3,5])
# a.numOfSubarrays([2,4,6])
# a.numOfSubarrays([1,2,3,4,5,6,7])
a.numOfSubarrays([1,2,3,4,5,6,7])
# a.numOfSubarrays([100,100,99,99])
# a.numOfSubarrays([7])