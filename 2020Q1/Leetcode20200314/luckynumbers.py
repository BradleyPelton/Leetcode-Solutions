from typing import List
import numpy as np
class Solution:
    def luckyNumbers (self, matrix: List[List[int]]) -> List[int]:
        arr = np.array(matrix)
        print(arr)


        # # m x n        rows x columns
        # lucky iff min of row and max of column 

        row_mins = arr.min(axis=1)
        print(row_mins)

        col_maxs = arr.max(axis=0)
        print(col_maxs)

        ans = []
        for ele in row_mins:
            if ele in col_maxs:
                ans.append(ele)
        print(ans)
        return(ans)






a = Solution()
a.luckyNumbers([[3,7,8],[9,11,13],[15,16,17]])
a.luckyNumbers([[1,10,4,2],[9,3,8,7],[15,16,17,12]])