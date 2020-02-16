from typing import List

class Solution:
    def makeConnected(self, n: int, connections: List[List[int]]) -> int:
        

        if len(connections) < n-1:
            return -1

        super_list = []
        for con in connections:
            super_list += con
        print(super_list)
        



a = Solution()
a.makeConnected(6,[[0,1],[0,2],[0,3],[1,2],[1,3]])