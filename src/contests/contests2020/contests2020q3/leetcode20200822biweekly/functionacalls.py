from typing import List

### first two attempts: I misunderstood the problem. you can add +1 at any time
### Switching two functionacalls2.py


class contests2020q4.leetcode20201017.Solution:
    def minOperations(self, nums: List[int]) -> int:
        """ """
        num_of_operations = 0


        two_arr = [2**i for i in range(31)]
        pow_arr = [] 
        ### STEP ONE
        ### FIND THE NEAREST POWER OF TWO THAT A ELEMENT IS ABOVE
        for val in nums:
            if val == 0:
                pow_arr.append([val,0])
            else:
                for j in range(len(two_arr)):
                    if val < two_arr[j]:
                        pow_arr.append([val,j-1])
                        break
        
        print(pow_arr)
        largest_power = max([pair[1] for pair in pow_arr])
        # print(f"largest power needed is {largest_power}")
        num_of_operations += largest_power

        for pair in pow_arr:
            # print(pair)
            if pair[0] != 0:
                # adding one index +1 operation
                num_of_operations += 1

                additional_ones_needed = pair[0] - two_arr[pair[1]]
                # print(f"For {pair[0]}, we need an additional {additional_ones_needed} ones")
                num_of_operations += additional_ones_needed

        print(num_of_operations)
        return num_of_operations
            



a = contests2020q4.leetcode20201017.Solution()
# a.minOperations(nums = [1,5])
# a.minOperations(nums = [2,2])
# a.minOperations(nums = [4,2,5])
# a.minOperations(nums = [3,2,2,4])
# a.minOperations(nums = [2,4,8,16])
a.minOperations(nums=[1000000000])  # Expected 42

## custom examples
