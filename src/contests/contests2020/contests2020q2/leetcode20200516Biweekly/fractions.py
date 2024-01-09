import math
from typing import List

# Accepted first try. Solved in 6 minutes
class contests2020q4.leetcode20201017.Solution:
    def simplifiedFractions(self, n: int) -> List[str]:
        """ """

        fracs = []

        for i in range(1, n+1):
            for j in range(1, i):
                if math.gcd(i,j) == 1:
                    fracs.append(f"{j}/{i}")

        # print(fracs)
        return(fracs)


a = contests2020q4.leetcode20201017.Solution()
a.simplifiedFractions(10)
