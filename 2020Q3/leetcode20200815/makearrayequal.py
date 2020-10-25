
## First attempt output limit exceeded... sloppy
### SEcond attempt accepted after 15 minutes.
### I was overthinking this and tried to solve it like a mathematician (calculating the formula
# for the number of steps need when I could just brute force)

class Solution:
    def minOperations(self, n: int) -> int:
        n_arr = [i*2 + 1 for i in range(n)]
        # print(n_arr)


        ### Theory: We always move to the center

        total_count = 0
        if n%2 == 1:
            # [1 , 3 , 5, ..., n/2 , n/2 +2, n/2 + 4, ..., n-2,  2n]
            # the first number to be corrected is [(1, 2n-1)] 
            # We need (n-1)/2 steps to equalize    (when n=7,we are fixing 1 -> 13, 6 steps )
            # the second number to be corrected is [(3, n-2)]
            # We need 

            midpoint = n
            for val in n_arr:
                # print(val)
                if val < n:
                    # print(f"equalizing {val}")
                    total_count += midpoint - val
                else:
                    break
        else:
            [1,3,5,7]
            midpoint = n
            for val in n_arr:
                if val < midpoint:
                    total_count += midpoint - val
                else:
                    break
        print(f"total count after everything is {total_count}")
        return total_count



a = Solution()
# a.minOperations(3)
a.minOperations(6)