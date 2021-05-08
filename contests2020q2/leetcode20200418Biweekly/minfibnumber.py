from itertools import combinations

# Time Limit Exceeded, for k = 513314. The answer was 11. Seems excessive 
class contests2020q4.leetcode20201017.Solution:
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

        # now that we have the fib_list, we return to the famous algorithm
        # where we find the ints in an array such that their sum equals something
        # There are a few tets

        # since k<10**9, len(k_fib_list) < 45
        k_fib_list = create_fib_list(k+1)
        if k in k_fib_list:
            return 1
        else:
            current_combo_length = 2  # number of numbers in fib_list attempting to sum to reach k
            for _ in range(50):
                # print(combo_sums(k_fib_list, current_combo_length))
                if k in combo_sums(k_fib_list, current_combo_length):
                    return current_combo_length
                else:
                    current_combo_length += 1

        # # INTERESTING IDEA
        # f_0 = 1
        # f_1 = 1
        # f_2 = f_0 + f_1
        # f_3 = f_1 + f_2

        # if k = f_i + f_j for some i, f_j
        # then k = f_


a = contests2020q4.leetcode20201017.Solution()
# print(a.findMinFibonacciNumbers(7))
# print(a.findMinFibonacciNumbers(10))
print(a.findMinFibonacciNumbers(513314))

