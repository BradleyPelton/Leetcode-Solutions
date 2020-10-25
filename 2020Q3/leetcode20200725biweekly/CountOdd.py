
### Time limit exceeded on an easy problem... 


# Accepted after multiple incorrect solutions and 29 minutes
## ARguably my worst easy problem in months.
## Step back and evaluate after

import math

class Solution:
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



a = Solution()
# a.countOdds(low = 3, high = 7)  #expected 3
# a.countOdds(low = 8, high = 10)  #expected 1
# a.countOdds(14, 17)  #expected 2
# a.countOdds(21,22)
# a.countOdds(13,18)  #expected 3
# a.countOdds(800445804, 979430543)

