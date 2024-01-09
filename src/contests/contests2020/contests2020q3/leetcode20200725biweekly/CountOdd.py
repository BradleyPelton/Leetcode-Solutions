
### Time limit exceeded on an contests2020q4.leetcode20201226biweekly.easy problem...


# Accepted after multiple incorrect solutions and 29 minutes
## ARguably my worst contests2020q4.leetcode20201226biweekly.easy problem in months.
## Step back and evaluate after

import math

class contests2020q4.leetcode20201017.Solution:
    def countOdds(self, low: int, high: int) -> int:
        if high == low + 1:
            print(1)
            return 1
        
        diff = high - low

        if low % 2 == 1 and high % 2 == 1:
            total_count = diff//2 + 1
        elif low % 2 == 1 and high % 2 == 0:
            total_count = diff//2 + 1
        elif low % 2 == 0 and high % 2 == 1:
            total_count = diff//2 + 1
        elif low % 2 == 0 and high % 2 == 0:
            total_count = diff//2


        

        print(total_count)
        return total_count



a = contests2020q4.leetcode20201017.Solution()
# a.countOdds(low = 3, high = 7)  #expected 3
# a.countOdds(low = 8, high = 10)  #expected 1
# a.countOdds(14, 17)  #expected 2
# a.countOdds(21,22)
# a.countOdds(13,18)  #expected 3
# a.countOdds(800445804, 979430543)

