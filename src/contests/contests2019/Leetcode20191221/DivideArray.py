
from typing import List
from collections import Counter

class contests2020q4.leetcode20201017.Solution:
    def isPossibleDivide(self, nums: List[int], k: int) -> bool:
        nums.sort()

        nodups = []
        [nodups.append(x) for x in nums if x not in nodups]
        # print(nodups)

        partitions = []
        current = []
        #splitting our list into [[1,2,3],[6,7,8],[9]]
        for i in range(len(nodups)):
            if len(current) == 0:
                current.append(nodups[i])
            else:
                if nodups[i] == nodups[i-1]+1:
                    # print(current)
                    current.append(nodups[i])
                else:
                    # print("shit broke when","nodups[i] is equal to ",nodups[i])
                    partitions.append(current)
                    current = [nodups[i]]
        partitions.append(current)
        # print(partitions)

        ans = [len(x) for x in partitions]
        ans.sort()
        # print(ans[-1])
        if ans[-1] >= k:
            return(True)
        else:
            return(False)


a = contests2020q4.leetcode20201017.Solution
print(a.isPossibleDivide([],[1,2,3,5,6,7,8,9,10,10,10,51,17,23,78,79,80,90,105],2))
