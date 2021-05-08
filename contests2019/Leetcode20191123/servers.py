from typing import List
import numpy as np

class contests2020q4.leetcode20201017.Solution:
    def countServers(self, grid: List[List[int]]) -> int:
        gridarray = np.array(grid)
        print(gridarray)
        badcount = 0



        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 1 and sum(grid[i]) == 1 and np.sum(gridarray,axis=0)[j] == 1:
                    badcount += 1
        
        print(np.sum(gridarray),badcount)
        return(np.sum(gridarray) -badcount)

        ###iterate through every element, if row sum and colsum = 1, add 1 to badcount

        