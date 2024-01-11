from typing import List 

from collections import defaultdict

class contests2020q4.leetcode20201017.Solution:
    def maxProbability(self, n: int, edges: List[List[int]], succProb: List[float], start: int, end: int) -> float:
        """ """
        edge_dict = defaultdict(list)
        for i in range(len(edges)):
            edge_dict[edges[i][0]].append((edges[i][1], succProb[i]))
        # print(edge_dict)

        all_solutions = []

        def dfs(node, current_path, current_prob, visited):
            """ depth first search starting at start"""
            nonlocal all_solutions

            if visited[node]:
                # print(f"found a visited node, {node}, returning")
                return
            else:
                visited[node] = 1

            if node is end:
                all_solutions.append((current_path, current_prob))
                print("found  a solution")
                return
            else:
                for edge in edge_dict[node]:
                    #  {0: [(1, 0.5), (2, 0.2)], 1: [(2, 0.5)]})
                    current_path.append(edge[0])
                    current_prob *= edge[1]
                    dfs(edge[0], current_path, current_prob, visited)
                    # current_path.pop()
                    # current_prob /= edge[1]


        visited = [0 for _ in range(n)]
        dfs(start, current_path=[start], current_prob=1, visited=visited)

        print(all_solutions)



a = contests2020q4.leetcode20201017.Solution()
a.maxProbability(n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2)
# a.maxProbability(n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2)