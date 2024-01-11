from typing import List

# SImple brute force. Accepted after 4 minutes

class contests2020q4.leetcode20201017.Solution:
    def countGoodTriplets(self, arr: List[int], a: int, b: int, c: int) -> int:
        """ """
        total_count = 0
        for i in range(len(arr)):
            for j in range(i, len(arr)):
                for k in range(j, len(arr)):
                    if i < j and j < k and k < len(arr):
                        if abs(arr[i] - arr[j]) <= a:
                            if abs(arr[j] - arr[k]) <= b:
                                if abs(arr[i] - arr[k]) <= c:
                                    total_count += 1
        print(total_count)
        return total_count

a = contests2020q4.leetcode20201017.Solution()
a.countGoodTriplets(arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3)
a.countGoodTriplets(arr = [1,1,2,2,3], a = 0, b = 0, c = 1)
