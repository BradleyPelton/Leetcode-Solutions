from typing import List
# after 4 attempts,
# this solution was accepted.
# the major takeaway was the construction of temp_list
# running the max function on each iteration was very expensive
# it was much better to store the current maximum in memory (see line 12)
class Solution:
    def numTimesAllBlue(self, light: List[int]) -> int:
        temp_list = []
        current_max = 0
        for i in range(len(light)):
            if light[i] > current_max:
                current_max = light[i]
                temp_list.append(current_max)
            else:
                temp_list.append(current_max)

        ans_count = 0
        for i in range(len(temp_list)):
            if temp_list[i] <= i+1:
                ans_count += 1
        return(ans_count)



a = Solution()
a.numTimesAllBlue([2,1,3,5,4])
a.numTimesAllBlue([3,2,4,1,5])
a.numTimesAllBlue([4,1,2,3])
a.numTimesAllBlue([2,1,4,3,6,5])
a.numTimesAllBlue([1,2,3,4,5,6])

