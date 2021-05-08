from typing import List


class contests2020q4.leetcode20201017.Solution:
    def removeInterval(self, intervals: List[List[int]], toBeRemoved: List[int]) -> List[List[int]]:
        def isintersect(interval1,interval2):
            # [[a,b],[c,d]]
            if interval2[0] < interval1[1]:
                return(True)
            return(False)


        
        # make disjoint
        answerList = []
        for i in range(len(intervals)-1):
            if isintersect(intervals[i],intervals[i+1]):
                a = [intervals[i][0],intervals[i+1][0]]
                answerList.append(a)
            else:
                answerList.append(intervals[i])
        

        # LAST INTERVAL
        secondtolast = intervals[-2]
        last = intervals[-1]
        if isintersect(secondtolast,last):
            answerList.append( [secondtolast[1],last[1]])
        else:
            answerList.append(last)
        

        print("NOW DISJOINT")
        print(answerList)

        donelist = []
        for interval in answerList:
            if interval[0] > toBeRemoved[0] and interval[1] < toBeRemoved[1]:
                pass
                # TOTALY REMOVED
            elif interval[0] > toBeRemoved[0] and interval[1] > toBeRemoved[1]:
                # to be removed [1,7]  but interval [5,9]
                donelist.append(    [toBeRemoved[1],interval[1]]   )
            elif interval[0] < toBeRemoved[0] and interval[1] < toBeRemoved[1]:
                # TO BE REMOVED [1,7] but interval is [0,5]
                donelist.append( [interval[0], toBeRemoved[0]])
        print("NOW REMOVED")
        print(donelist)
        return donelist




a = contests2020q4.leetcode20201017.Solution()
a.removeInterval([[0,2],[3,4],[5,7]],[1,6])