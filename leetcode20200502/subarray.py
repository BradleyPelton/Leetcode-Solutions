from typing import List
# Time limit exceeded on this attempt. switching to subarray2
class Solution:
    def longestSubarray(self, nums: List[int], limit: int) -> int:
        """ """
        valid_subarrays = []

        for i in range(len(nums)):
            ith_arr = [nums[i]]
            current_index = i
            while current_index < len(nums) - 1:
                current_index += 1
                if abs(ith_arr[0] - nums[current_index]) <= limit:
                    # print('less than first gate')
                    if abs(ith_arr[-1] - nums[current_index]) <= limit:
                        # print("less than last gate")
                        ith_arr.append(nums[current_index])
                        ith_arr.sort()
                    else:
                        break
                else:
                    break
            valid_subarrays.append(ith_arr)
        print(valid_subarrays)

        valid_lengths = [len(arr) for arr in valid_subarrays]
        print(max(valid_lengths))
        return(max(valid_lengths))


a = Solution()
# a.longestSubarray([8, 2, 4, 7], 4)
# a.longestSubarray([10,1,2,4,7,2], 5)
a.longestSubarray([4,2,2,2,4,4,2,2], 0)
