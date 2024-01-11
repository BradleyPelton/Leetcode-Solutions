from typing import List
# REALLLLYYYYYY????????
# TIME LIMIT EXCEEDED
class contests2020q4.leetcode20201017.Solution:
    def numTimesAllBlue(self, light: List[int]) -> int:
        
        moment_list = [0]*(len(light))
        # print(moment_list)
        ans_count = 0
        for i in range(len(light)):
            # print(max(light[0:i+1]))
            if max(light[0:i+1]) <= i+1:
                ans_count += 1
        # print(ans_count)
        return(ans_count)


a = contests2020q4.leetcode20201017.Solution()
a.numTimesAllBlue([2,1,3,5,4])
a.numTimesAllBlue([3,2,4,1,5])
a.numTimesAllBlue([4,1,2,3])
a.numTimesAllBlue([2,1,4,3,6,5])
a.numTimesAllBlue([1,2,3,4,5,6])