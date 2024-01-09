from typing import List
from connections import Counter

class contests2020q4.leetcode20201017.Solution:
    def makeConnected(self, n: int, connections: List[List[int]]) -> int:
        

        if len(connections) < n-1:
            return -1

        super_list = []
        for con in connections:
            super_list += con
        print(super_list)
        
        mylist = list(Counter())



a = contests2020q4.leetcode20201017.Solution()
a.makeConnected(6,[[0,1],[0,2],[0,3],[1,2],[1,3]])