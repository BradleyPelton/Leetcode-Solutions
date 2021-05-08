from typing import List


# contests2020q4.leetcode20201017.Solution timed out (which means it passed the first 50 cases, so its technically right)
# just too slow
class contests2020q4.leetcode20201017.Solution:
    def numTimesAllBlue(self, light: List[int]) -> int:
        
        # A bulb is yellow iff there exists a bulb that is turned off to its left

        # the plan
        # iterate over each moment
        # evaluate if temp has any gaps
        # if gaps, then not all are blue

        def all_blue(moment_list):
            if moment_list == [1] + [0]*(len(moment_list)-1):
                return(True)

            for i in range(1,len(moment_list)):
                if moment_list[i] == 1: # if a bulb is turned on
                    if moment_list[i-1] == 0: # presence of a gap
                        return(False)
            return(True)

        moment_list = [0]*(len(light))
        # print(moment_list)
        ans_count = 0
        for i in range(len(light)):
            # print(light[i])
            moment_list[light[i]-1] = 1
            # print(moment_list)
            if all_blue(moment_list):
                ans_count += 1
        # print(ans_count)
        return(ans_count)
    
        
a = contests2020q4.leetcode20201017.Solution()
a.numTimesAllBlue([2,1,3,5,4])   
a.numTimesAllBlue([3,2,4,1,5])         
a.numTimesAllBlue([4,1,2,3])
a.numTimesAllBlue([2,1,4,3,6,5])
a.numTimesAllBlue([1,2,3,4,5,6])