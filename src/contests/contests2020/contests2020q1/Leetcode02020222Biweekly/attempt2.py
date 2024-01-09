from typing import List
from collections import defaultdict


# HIDEOUS ABOMINATION OF A SOLUTION, BUT ACCEPTED
# WHY DID MY SORT NOT SORT CORRECTLY WHEN THE VALUE OF NUMBER_OF_ONES WAS THE SAME
# SORT VS SORTED
class contests2020q4.leetcode20201017.Solution:
    def sortByBits(self, arr: List[int]) -> List[int]:

        def number_of_ones(num):
            bin_num = bin(num)[2:]

            count = bin_num.count('1')
            return(count)

        # arr.sort(key=lambda x: number_of_ones(x))
        # print(arr)


        # initializing my_dict
        my_dict = defaultdict(list)
        for item in arr:
            my_dict[number_of_ones(item)].append(item)
        print(my_dict)


        # sorting my_dict by first key, then sorting the lists stored in val

        ans = []
        for i in range(0,10000):
            try:
                ans.extend(sorted(my_dict[i]))
            except (TypeError,KeyError):
                pass
        print(ans)
        return(ans)
a = contests2020q4.leetcode20201017.Solution()
# a.sortByBits([0,1,2,3,4,5,6,7,8])
# a.sortByBits([1024,512,256,128,64,32,16,8,4,2,1])
# a.sortByBits([2,3,5,7,11,13,17,19])
# a.sortByBits([10,100,1000,10000])
# a.sortByBits([10000,10000])
a.sortByBits([1111,7644,1107,6978,8742,1,7403,7694,9193,4401,377,8641,5311,624,3554,6631])
