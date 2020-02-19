from typing import List


#TIMED OUT
class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        
        intervals.sort()
        copy = intervals[:]
        print(copy)

        #since sorted, impossible for interval[i+1] to contain interval [i]
        for i in range(len(intervals)):
            for j in range(i,len(intervals)):
                if intervals[i][0] <= intervals[j][0]  and intervals[i][1] >= intervals[j][1] and intervals[i] != intervals[j]:
                    try:
                        copy.remove(intervals[j])
                    except (ValueError,IndexError): 
                        pass
                else: 
                    print()
        print(copy)
        return(len(copy))






c = Solution()
c.removeCoveredIntervals([[34335,39239],[15875,91969],[29673,66453],[53548,69161],[40618,93111]]) #prints 2
# c.removeCoveredIntervals([[1,4],[3,6],[2,8]])