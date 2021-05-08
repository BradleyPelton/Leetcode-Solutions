from functools import reduce
from math import sqrt
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
                break
            elif (factors[lower-1]*factors[upper] == num or 
                factors[lower]*factors[upper+1] == num):
                print("found another solution, but its complicated")

    if len(factors) % 2 == 1:
        center = (len(factors)-1)//2
        upper= center - 1
        upper = center + 1
        if factors[upper]*factors[center] == num:
            return(factors[center],factors[upper])
        elif factors[lower]*factors[center] == num:
            return(factors[lower],factors[center])
        else:
            print("shit got more complicated")
# smallest_factor_pair([1, 2, 7, 14, 49, 98],98)

a = factors(81)
a.sort()
print(a)
print(len(a))