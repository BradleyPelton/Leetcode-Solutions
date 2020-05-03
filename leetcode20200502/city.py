from typing import List
# Finished in 3 minutes. Beautiful solution.
# Forgot to return ans[0] instead of ans. first solution rejected
class Solution:
    def destCity(self, paths: List[List[str]]) -> str:
        
        path_dict = {path[0]: path[1] for path in paths}

        print(path_dict.keys())
        print(path_dict.values())

        ans = [x for x in path_dict.values() if x not in path_dict.keys()]
        print(ans)
        return(ans[0])

a = Solution()
# a.destCity([["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]])
a.destCity([["B","C"],["D","B"],["C","A"]])