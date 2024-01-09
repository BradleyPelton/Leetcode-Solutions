from typing import List
from collections import defaultdict

## brutal problem. Easy to conceptualize, but to think fo a way of optimally choosing these
## substrings is an insane optimization problem. Moving back to numberofnodes


class contests2020q4.leetcode20201017.Solution:
    def maxNumOfSubstrings(self, s: str) -> List[str]:
        
        s_chars = list(set(s))
        # print(s_chars)

        first_occ = s.index('c')
        last_occ = len(s) - 1 - s[::-1].index('c')

        occ_dict = dict()
        for char in s_chars:
            first_occ = s.index(char)
            last_occ = len(s) - 1 - s[::-1].index(char)
            occ_dict[char] = [first_occ, last_occ]
        # print(occ_dict)
        # {'d': [6, 6], 'c': [4, 5], 'a': [0, 3], 'b': [1, 2]}

        occ_list = [(k, v) for k, v in occ_dict.items()]
        # print(occ_list)
        occ_list.sort(key= lambda x: x[1][1]-x[1][0])
        # print(occ_list)
        # [('d', [6, 6]), ('b', [1, 2]), ('c', [4, 5]), ('a', [0, 3])]

        ans = []

        for i in range(len(s)-1):
            ith_first_occ = occ_dict[s[i]][0]
            ith_last_occ = occ_dict[s[i]][1]
            print(s[i], ith_first_occ, ith_last_occ)
            if ith_first_occ == ith_last_occ:
                ans.append(s[i])
            else:
                # find the smallest 



a = contests2020q4.leetcode20201017.Solution()
# a.maxNumOfSubstrings(s = "adefaddaccc")
a.maxNumOfSubstrings(s="abbaccd")