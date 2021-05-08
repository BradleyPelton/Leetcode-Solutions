from typing import List

# Accepted after 6 minutes. A little confusing to understand

class contests2020q4.leetcode20201017.Solution:
    def restoreString(self, s: str, indices: List[int]) -> str:
        output_list = [s[indices[i]] for i in range(len(s))]
        # print(output_list)

        pairs = []
        for i in range(len(s)):
            pairs.append((i,s[i], indices[i]))
        # print(pairs)
        pairs.sort(key=lambda x: x[2])
        # print(pairs)

        ans = ''
        for pair in pairs:
            ans += pair[1]
        print(ans)
        return ans


a = contests2020q4.leetcode20201017.Solution()
# a.restoreString(s = "codeleet", indices = [4,5,6,7,0,2,1,3])
a.restoreString(s = "abc", indices = [0,1,2])
# a.restoreString(s = "aiohn", indices = [3,1,4,2,0])