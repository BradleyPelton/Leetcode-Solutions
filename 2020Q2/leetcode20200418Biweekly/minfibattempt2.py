from itertools import combinations

# Time Limit Exceeded, for k = 513314. The answer was 11. Seems excessive 
# Ran out of time. Spent 1 hour on this at least
# Pretty frustrating 
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

        def combo_sums(numlist, c):
            """ return a list of values who are the sum of c number of numbers in numlist"""
            comb_list = combinations(numlist, c)    
            comb_sums = [sum(comb) for comb in comb_list]
            return comb_sums
            # return list(set(comb_sums))

        # since k<10**9, len(k_fib_list) < 45
        k_fib_list = create_fib_list(k+1)
        if k in k_fib_list:
            return 1
        else:
            current_combo_length = 2  # number of numbers in fib_list attempting to sum to reach k
            for _ in range(50):
                # print(combo_sums(k_fib_list, current_combo_length))
                c = combo_sums(k_fib_list[2:], current_combo_length)
                for combo in c:
                    if k
                    return current_combo_length
                else:
                    current_combo_length += 1



a = Solution()
print(a.findMinFibonacciNumbers(7))
print(a.findMinFibonacciNumbers(10))
print(a.findMinFibonacciNumbers(19))    
# print(a.findMinFibonacciNumbers(513314))
