from typing import List
from collections import Counter
from collections import defaultdict

# Accepted after 15 minutes. DDOS attack killed thirty minutes of this challenge, sigh

class contests2020q4.leetcode20201017.Solution:
    def canArrange(self, arr: List[int], k: int) -> bool:
        
        remainder_dict = defaultdict(int)
        for val in arr:
            remainder_dict[val % k] += 1

        print(remainder_dict)

        pairs = [(i, k-i) for i in range(1,k//2 + 1)]
        # print(pairs)

        if remainder_dict[0] % 2 != 0:
            return False

        for pair in pairs:
            lower = pair[0]
            upper = pair[1]
            if remainder_dict[lower] != remainder_dict[upper]:
                print(f"found something broken, {lower, upper}")
                return False
        else:
            print("nothing went wrong")
            return True


a = contests2020q4.leetcode20201017.Solution()
# a.canArrange([1,2,3,4,5,10,6,7,8,9], 5)
# a.canArrange([1,2,3,4,5,6], 7)
# a.canArrange([1,2,3,4,5,6], 10)
# a.canArrange([-10,10], 2)
a.canArrange([-1,1,-2,2,-3,3,-4,4], 3)