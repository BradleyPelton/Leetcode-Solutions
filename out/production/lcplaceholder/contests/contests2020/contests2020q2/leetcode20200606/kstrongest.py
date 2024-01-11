from typing import List


# Accepted first try. Took about 10 minutes, 10:55 is solved time
# Pretty simple. Lambda sort is god like. I wonder why i didnt have to consider the edge case
# where sorted value (abs(x- median)) was the same
class contests2020q4.leetcode20201017.Solution:
    def getStrongest(self, arr: List[int], k: int) -> List[int]:
        """ """

        arr.sort()
        median = arr[(len(arr) - 1) // 2]
        # print(arr[median])

        # for val in arr:
        #     print(val, abs(val - median))

        special_sort = sorted(arr, key=lambda x: abs(x - median))
        # print(special_sort)

        ans_arr = special_sort[-k:]
        # print(ans_arr)
        return ans_arr



a = contests2020q4.leetcode20201017.Solution()
# a.getStrongest([1,2,3,4,5], 2)
# a.getStrongest([1,1,3,5,5], 2)
# a.getStrongest([6,7,11,7,6,8],5)
# a.getStrongest([6,-3,7,2,11], 3)
a.getStrongest([-7,22,17,3], 2)