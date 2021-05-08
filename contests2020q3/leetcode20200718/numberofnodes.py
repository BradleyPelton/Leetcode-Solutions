from typing import List
from collections import defaultdict

# first attempt rejected incorrect solution. see test cases below


class contests2020q4.leetcode20201017.Solution:
    def countSubTrees(self, n: int, edges: List[List[int]], labels: str) -> List[int]:
        """ """
        answer_list = []

        edge_dict = defaultdict(list)
        for edge in edges:
            edge_dict[edge[0]].append(edge[1])
            edge_dict[edge[1]].append(edge[0])

        # print(edge_dict)
        # {0: [1, 2], 1: [4, 5], 2: [3, 6]}


        def dfs_search(node, master_int, master_val, child_agrees_list, visited):
            if node not in edge_dict.keys():
                return child_agrees_list
            else:
                for val in edge_dict[node]:
                    if labels[val] == master_val and val not in visited:
                        child_agrees_list.append(val)
                        visited.append(val)
                for val in edge_dict[node]:
                    dfs_search(val, master_int, master_val, child_agrees_list, visited)


        for i in range(n):
            ith_child_agrees = [i]
            visited = []
            dfs_search(i, i, labels[i], ith_child_agrees, visited)
            print(i, ith_child_agrees)  
            answer_list.append(len(ith_child_agrees))
        print(answer_list)
        return answer_list


a = contests2020q4.leetcode20201017.Solution()
# a.countSubTrees(n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], labels = "abaedcd")  # expected [2,1,1,1,1,1,1]
# a.countSubTrees(n = 4, edges = [[0,1],[1,2],[0,3]], labels = "bbbb")  # expected [4,2,1,1]
# a.countSubTrees(n = 5, edges = [[0,1],[0,2],[1,3],[0,4]], labels = "aabab")  # expected [3,2,1,1,1]
# a.countSubTrees(n = 6, edges = [[0,1],[0,2],[1,3],[3,4],[4,5]], labels = "cbabaa")  # expected [1,2,1,1,2,1]
# a.countSubTrees(n = 7, edges = [[0,1],[1,2],[2,3],[3,4],[4,5],[5,6]], labels = "aaabaaa")  # Expected [6,5,4,1,3,2,1]

# FIRST SUBMISSION INCORRECT SOLUTION
a.countSubTrees(n=4, edges=[[0,2],[0,3],[1,2]], labels="aeed")  # expected [1,1,2,1]
