from typing import List

## First attempt rejected Time Limit Exceeded
## Switching to latestgroup2.py

class contests2020q4.leetcode20201017.Solution:
    def findLatestStep(self, arr: List[int], m: int) -> int:
        """ """

        curr_string = "0" * len(arr)
        print(curr_string)

        latest_step_with_m_group = 0
        current_step = 0
        for pos in arr:
            current_step += 1
            curr_string = curr_string[:pos-1] + '1' + curr_string[pos:]
            # print(curr_string)

            one_groups = curr_string.split("0")
            one_lengths = [len(group) for group in one_groups]
            if m in one_lengths:
                latest_step_with_m_group = current_step
            if m < min(one_lengths):
                break
        
        if latest_step_with_m_group == 0:
            print("edge case, m never achieved")
            return -1

        print(latest_step_with_m_group)
        return latest_step_with_m_group



a = contests2020q4.leetcode20201017.Solution()
a.findLatestStep(arr = [3,5,1,2,4], m = 1)
# a.findLatestStep(arr = [3,1,5,4,2], m = 2)