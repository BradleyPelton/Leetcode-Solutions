from typing import List

# I majorly tripped up here. Multiple incorrect solutions. Took 19 minutes


class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        """ """

        # for i in range(1, len(arr)):
        #     delta = arr[i] - arr[i-1] - 1
        #     # print(f"delta between {arr[i-1]} and {arr[i]} is {delta}")

        #     if number_of_missing + delta < k:
        #         number_of_missing += delta
        #     else:
        #         print("starting counting logic")

        # for i in range(arr[0],1000):
        #     try:
        #         if arr[current_index] == i:
        #             current_index += 1
        #         else:
        #             number_of_missing += 1

        #         if number_of_missing == k:
        #             print(f"found the solution {i}")
        #             return i
                
        #         if current_index == len(arr) - 1:
        #             print("overflow case")
        #             ans = arr[-1] + (k - number_of_missing)
        #             print(ans)
        #             return ans

        #         print(f"i is {i}, arr[i] is {arr[i]}, number of missing is {number_of_missing}")
        #     except IndexError:
        #         pass

        number_of_missing = 0
        for i in range(1, 10000):
            if i not in arr:
                number_of_missing += 1
            if number_of_missing == k:
                print(i)
                return i
        


a = Solution()
a.findKthPositive(arr = [2,3,4,7,11], k = 5)
# a.findKthPositive(arr = [1,2,3,4], k = 2)
# a.findKthPositive([1,2,3,4] , 2) # expected 6