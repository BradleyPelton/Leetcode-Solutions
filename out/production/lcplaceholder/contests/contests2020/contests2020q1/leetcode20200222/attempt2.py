from typing import List
from math import sqrt
from functools import reduce


# ACCEPTED. NOT SO ELEGANT SOLUTION, BUT IT WORKED
# NOT SURE, BUT I THINK THE CENTER TO VALUES IN THE FACTORS() LIST
# ARE ALWAYS THE TWO SMALLEST VALUES
class contests2020q4.leetcode20201017.Solution:
    def closestDivisors(self, num: int) -> List[int]:

        def factors(n):
                step = 2 if n%2 else 1
                return list(reduce(list.__add__,
                            ([i, n//i] for i in range(
                                1, int(sqrt(n))+1, step) if n % i == 0)))

        def smallest_factor_pair(factors,num):
            """
                returns the smallest pair of ints in factors
            such that int1*int2 ==num """
            
            if len(factors) % 2 == 0:
                lower = (len(factors)//2)-1
                upper= len(factors)//2
                for _ in range(len(factors)):
                    if factors[lower]*factors[upper] == num:
                        print("found a solution",factors[lower],factors[upper])
                        return([factors[lower],factors[upper]])
                    elif (factors[lower-1]*factors[upper] == num or 
                        factors[lower]*factors[upper+1] == num):
                        print("found another solution, but its complicated")

            if len(factors) % 2 == 1:
                center = (len(factors)-1)//2
                upper= center - 1
                upper = center + 1
                if factors[upper]*factors[center] == num:
                    return([factors[center],factors[upper]])
                elif factors[lower]*factors[center] == num:
                    return(factors[lower],factors[center])
                else:
                    print("shit got more complicated")

        plus_one_factors = factors(num+1)
        plus_two_factors = factors(num+2)
        plus_one_factors.sort()
        plus_two_factors.sort()

        plus_one_smallest_pair = smallest_factor_pair(plus_one_factors,num+1)
        print(plus_one_smallest_pair)
        plus_two_smallest_pair = smallest_factor_pair(plus_two_factors,num+2)
        print(plus_two_smallest_pair)

        plus_one_dif = plus_one_smallest_pair[1]-plus_one_smallest_pair[0]
        plus_two_dif = plus_two_smallest_pair[1]-plus_two_smallest_pair[0]

        if plus_one_dif < plus_two_dif:
            print("returning solution",plus_one_smallest_pair)
            return(plus_one_smallest_pair)
        else:
            print("returning solution",plus_two_smallest_pair)
            return(plus_two_smallest_pair)


        # print(plus_one_factors,plus_two_factors)





a = contests2020q4.leetcode20201017.Solution()
a.closestDivisors(8)