from typing import List

### YESSSSS. Sucessfull refactor. Accepted on third attemtp 
### Interesting that the OPTIMAL APPROACH is just to divide by 2 or subtract one until you reach 0
### I'm sure there is an elegant theorem to prove this mathematical fact, but I abused it as if 
### I know it was a fact.



class contests2020q4.leetcode20201017.Solution:
    def minOperations(self, nums: List[int]) -> int:
        """ """
        num_of_operations = 0

        total_ones = 0
        all_twos = []
        for num in nums:
            curr = num
            num_of_ones = 0
            num_of_twos = 0
            for _ in range(100):
                if curr % 2 == 1:
                    num_of_ones += 1
                    curr -= 1
                else:
                    num_of_twos += 1
                    curr /= 2

                if curr == 0:
                    break
                # print(curr)

            total_ones += num_of_ones
            all_twos.append(num_of_twos)
            # print(f"ones need {num_of_ones}, twos needed {num_of_twos}")

        # all ones
        # print(f"total ones is {total_ones}")
        num_of_operations += total_ones

        # twos
        max_twos = max(all_twos)
        # print(f"max two is {max_twos}")
        num_of_operations += max_twos

        print(f"final answer is {num_of_operations}")
        # print(num_of_operations)
        return num_of_operations

a = contests2020q4.leetcode20201017.Solution()
a.minOperations(nums = [1,5])
a.minOperations(nums = [2,2])
a.minOperations(nums = [4,2,5])
a.minOperations(nums = [3,2,2,4])
a.minOperations(nums = [2,4,8,16])
a.minOperations(nums=[1000000000])  # Expected 42

## custom examples
