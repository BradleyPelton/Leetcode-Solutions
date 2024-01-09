from typing import List

class contests2020q4.leetcode20201017.Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        for i in range(len(arr)-1):
            arr[i] = max(arr[i+1:])
        arr[-1] = -1
        print(arr)

a = contests2020q4.leetcode20201017.Solution()
a.replaceElements([17,18,5,4,6,1])
