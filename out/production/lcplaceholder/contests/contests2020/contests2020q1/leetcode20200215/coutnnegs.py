from typing import List
class contests2020q4.leetcode20201017.Solution:
    def countNegatives(self, grid: List[List[int]]) -> int:
        count = 0

        for li in grid:
            for i in li:
                if int(i) <0:
                    count += 1
        
        print(count)
        return(count)


a = contests2020q4.leetcode20201017.Solution()
a.countNegatives([[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]])
