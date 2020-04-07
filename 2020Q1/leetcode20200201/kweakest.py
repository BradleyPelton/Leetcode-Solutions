

import numpy as np
from typing import List
class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        print(mat)
        copy = mat[:]
        for i in range(len(mat)):
            tempsum = sum(mat[i])
            copy[i].append(i) #position -2
            copy[i].append(tempsum) #sum -1
        print(copy)

        copy.sort(key = lambda temp: temp[-1])
        print(copy)

        ans = []
        for i in range(k):
            ans.append(copy[i][-2])
        print(ans)
        return(ans)



a = Solution()
a.kWeakestRows([[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]],3)





