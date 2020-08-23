from typing import List

### Yeah I giveup. I dont see a way to optimize this anymore. I'm satisfied with my timeout solution
### since its not horribly slow but it is slow


class Solution:
    def findLatestStep(self, arr: List[int], m: int) -> int:
        """ """

        one_groups = []
        current_step = 0
        latest_step_with_m_group = 0

        for pos in arr:
            current_step += 1

            for group in one_groups:
                if pos == group[0] - 1:
                    group[0] -= 1
                    break
                elif pos == group[1] + 1:
                    group[1] += 1
                    break
            else:
                # add a new group
                one_groups.append([pos,pos])
            print(one_groups)



            ### MERGE GROUPS





            # if m in one_lengths:
            #     latest_step_with_m_group = current_step
            # if m < min(one_lengths):
            #     break
        
        # if latest_step_with_m_group == 0:
        #     print("edge case, m never achieved")
        #     return -1

        # print(latest_step_with_m_group)
        # return latest_step_with_m_group



a = Solution()
a.findLatestStep(arr = [3,5,1,2,4], m = 1)
# a.findLatestStep(arr = [3,1,5,4,2], m = 2)