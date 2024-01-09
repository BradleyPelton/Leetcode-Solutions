# Accepted after first try
## took about 18 minutes. I actualy thought of trying a sliding window but then the simple split
## method came to mind.


class contests2020q4.leetcode20201017.Solution:
    def numSub(self, s: str) -> int:
        """ Sliding window? I feel like there should be a solution"""

        total_count = 0

        if s == [0 for _ in range(len(s)-1)]:
            print("all zero edge case")
            return 0

        one_strings = s.split("0")
        one_strings = [s for s in one_strings if len(s) != 0]

        for substring in one_strings:
            new_subs = (len(substring) * (len(substring)+1)) / 2
            # print(substring, new_subs)
            total_count += new_subs

        ans = total_count % (10**9 + 7)
        ans = int(ans)
        print(ans)
        return ans
            




        # current_substring = []
        # total_count = 0

        # for i in range(len(s)-1):
        #     if s[i] == 0:
        #         if current_substring == []:
        #             pass
        #         else:
        #             total_count += len(current_substring)
                    
        #         else 
        #     elif s[i] == 1:

a = contests2020q4.leetcode20201017.Solution()
# a.numSub("0110111")
# a.numSub("111111")
# a.numSub('101')
a.numSub('000')