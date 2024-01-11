from math import sqrt
from functools import reduce

# Accepted first try after 8 minutes.
# I wonder why there isnt a nice python library for factors. TODO- research

class contests2020q4.leetcode20201017.Solution:
    def kthFactor(self, n: int, k: int) -> int:
        
        def factors(n):
                step = 2 if n%2 else 1
                return list(reduce(list.__add__,
                            ([i, n//i] for i in range(1, int(sqrt(n))+1, step) if n % i == 0)))
        
        n_facts = list(set(factors(n)))
        n_facts.sort()

        # print(n_facts)

        try:
            # print(n_facts[k-1])
            return n_facts[k-1]
        except:
            # print("except")
            return -1

a = contests2020q4.leetcode20201017.Solution()
# a.kthFactor(12,3)
# a.kthFactor(7,2)
# a.kthFactor(4,4)
# a.kthFactor(1,1)
a.kthFactor(1000,3)

