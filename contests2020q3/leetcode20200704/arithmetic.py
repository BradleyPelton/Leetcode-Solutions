from typing import List

## Accepted after 3 minutes. Not even sure how my solution worked, but hey, it worked

class contests2020q4.leetcode20201017.Solution:
    def canMakeArithmeticProgression(self, arr: List[int]) -> bool:
        """ """
        arr.sort()

        diff = [arr[i] - arr[i+1] for i in range(len(arr)-1)]

        print(diff)

        if len(list(set(diff))) == 1:
            print("trueee")
            return True
        else:
            return False

a = contests2020q4.leetcode20201017.Solution()
# a.canMakeArithmeticProgression([3,5,1])
a.canMakeArithmeticProgression([1,2,4])
