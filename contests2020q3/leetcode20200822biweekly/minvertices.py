from typing import List
from collections import defaultdict

### Accepted after second attempt
### First attempt I accidentally returned the number of nodes instead a list of nodes




class contests2020q4.leetcode20201017.Solution:
    def findSmallestSetOfVertices(self, n: int, edges: List[List[int]]) -> List[int]:
        """ """ 


        ### Theory: The answer is always the maximum number of "ROOT" nodes


        graph = defaultdict(list)

        good_nodes = []
        for edge in edges:
            good_nodes.append(edge[1])

        unique_good_nodes = set(good_nodes)


        root_nodes = []
        for i in range(n):
            if i not in unique_good_nodes:
                root_nodes.append(i)
        
        print(root_nodes)
        return root_nodes

        


a = contests2020q4.leetcode20201017.Solution()
a.findSmallestSetOfVertices(n = 6, edges = [[0,1],[0,2],[2,5],[3,4],[4,2]])
a.findSmallestSetOfVertices(n = 5, edges = [[0,1],[2,1],[3,1],[1,4],[2,4]])