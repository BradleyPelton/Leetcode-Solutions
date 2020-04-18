import itertools

# Time Limit Exceeded, for k = 513314. The answer was 11. Seems excessive 
class Solution:
    def findMinFibonacciNumbers(self, k: int) -> int:
        """ """
        def create_fib_list(n):
            """ return a lsit of fib numbers less than n"""
            fib_list = [1, 1]

            if n == 1:
                return []
            elif n == 2:
                return fib_list

            while fib_list[-1] < n:
                fib_list.append(fib_list[-2]+fib_list[-1])

            fib_list.pop()
            return(fib_list)

        k_fib_list = create_fib_list(k+1)

        pro = itertools.product(k_fib_list, k_fib_list)


    
        func = partial(check_sum_array, T)
        sums = list(itertools.starmap(