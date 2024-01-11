from typing import List


class citynode:
    def __init__(self, val):
        self.val = val
        self.paths_away = []
        self.paths_towards = []


class contests2020q4.leetcode20201017.Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:

        # city_nodes = [citynode(i) for i in range(n)]
        city_nodes = [(i, [], []) for i in range(n)]
        print(city_nodes)

        for con in connections:
            city_nodes[con[0]][1].append(con[1])
            city_nodes[con[1]][2].append(con[0])
        
        for city in city_nodes:
            print(city)

a = contests2020q4.leetcode20201017.Solution()
a.minReorder(6, [[0,1],[1,3],[2,3],[4,0],[4,5]])