from typing import List

from collections import Counter

# Solved first attempt. Wasted about 10 minutes debugging. Turns out i was overwritting the value
# of k by iterating over k,v for k,v in arr_counter.items() ... frustrating choice of values
class contests2020q4.leetcode20201017.Solution:
    def findLeastNumOfUniqueInts(self, arr: List[int], k: int) -> int:
        """ """
        arr_counter = dict(Counter(arr))
        # print(arr_counter)

        occ_list = []
        for l,v in arr_counter.items():
            occ_list.append((l,v))
        # print(occ_list)

        occ_list.sort(key=lambda x: x[1])
        print(occ_list)

        pop_counter = 0
        for occ in occ_list:
            # print(occ)
            occ_val = occ[1]
            if occ_val > k:
                break
            else:
                k -= occ_val
                pop_counter += 1
        # print(pop_counter)
        # print(occ_copy[pop_counter:])
        print(len(occ_list) - pop_counter)

        return len(occ_list) - pop_counter

a = contests2020q4.leetcode20201017.Solution()
# a.findLeastNumOfUniqueInts([5,5,4], 1)
a.findLeastNumOfUniqueInts([4,3,1,1,3,3,2], 3)