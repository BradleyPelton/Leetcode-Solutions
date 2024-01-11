from typing import List
# 18 minutes to solve. Really weird problem to grasp
# first solution start_value = 1882, had to change while loop to While True
class contests2020q4.leetcode20201017.Solution:
    def minStartValue(self, nums: List[int]) -> int:
        # start + nums[0] > 0
        # (start + nums[0]) + nums[1] > 0
        # ...

        start_value = 1

        while True:
            print(f"starting value is {start_value}")
            current_sum = start_value
            for i in range(len(nums)):
                if current_sum + nums[i] < 1:
                    start_value += 1
                    break
                else:
                    current_sum += nums[i]
            else:
                break
        print(start_value)
        return(start_value)


a = contests2020q4.leetcode20201017.Solution()
a.minStartValue([-3,2,-3,4,2])
a.minStartValue([1,-2,-3])
a.minStartValue([1,2])