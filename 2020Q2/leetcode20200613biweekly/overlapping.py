from typing import List


class Solution:
    def minSumOfLengths(self, arr: List[int], target: int) -> int:
        """ """

        print(arr)
        subs_and_indexes = []

        current_sum = 0
        current_left = 0  # INCLUSIVE
        current_right = 0  # INCLUSIVE

        for _ in range(1000):
            # print(f"current window is {arr[current_left:current_right + 1]}, current sum is {current_sum}")
            if current_sum == target:
                print(f"found a subarray that works, {arr[current_left:current_right + 1]}")
                subs_and_indexes.append(
                    [arr[current_left:current_right], current_left, current_right]
                )

                if current_right == len(arr) - 1:
                    print("breaking: current_sum == target break")
                    break
                else:
                    current_right += 1
                    current_sum += arr[current_right]

            elif current_sum > target:
                # move right
                current_sum -= arr[current_left]
                current_left += 1
                pass
            elif current_sum < target:
                if current_right > len(arr) - 1:
                    break
                current_right += 1
                current_sum += arr[current_right]

        print(subs_and_indexes)

        # current_smallest = 0
        # for i in range(len(subs_and_indexes)):
        #     for j in range(len(subs_and_indexes)):
        #         # if they don't overlap
        #         if (
        #             subs_and_indexes[i][1] < subs_and_indexes[j][1] and
        #             subs_and_indexes[i][2] < subs_and_indexes[j][1] and
        #             subs_and_indexes[i][2] < subs_and_indexes[j][2]
        #         ):
        #             if len(subs_and_indexes[i][0]) + len(subs_and_indexes[j][0]) < current_smallest:
        #                 print("found a solution")
        #                 current_smallest = len(subs_and_indexes[i][0]) + len(subs_and_indexes[j][0])
        
        # print(current_smallest)
        # return current_smallest

a = Solution()
# a.minSumOfLengths([3,2,2,4,3], 3)
# a.minSumOfLengths([7,3,4,7], 7)
a.minSumOfLengths([3,1,1,1,5,1,2,1], 3)