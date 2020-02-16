class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        """docstring for solution"""
        def hasOverlap(foo,bar):
            """foo,bar both lists foo = [a,b] bar = [c,d]
            returns true if the two intervals overlap
            FOO NECESSARILY small (a<c)
            """
            if foo[1] > bar[0]:
                return(True)
            else:
                return(False)
        
        copy = intervals[:]
        for i range(1,len(intervals)-1):
            if hasOverlap(intervals[i-1],intervals[i]) and hasOverlap(intervals[i],intervals[i+1])



