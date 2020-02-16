import numpy as np
from typing import List

class Solution:
    def reconstructMatrix(self, upper: int, lower: int, colsum: List[int]) -> List[List[int]]:
        # 2xn matrix
        # upper is the sum fo the top row, lower is lower
        # colum[i] is the sum of the ith columm, values ALWAYS 0,1,2

        a = np.zeros((2,len(colsum)))
        # print(a)

        if upper + lower != sum(colsum):
            return(np.zeros((0,0)))
        
        for i in range(len(colsum)):
            if colsum[i] == 2:
                a[0,i] = 1
                a[1,i] = 1
        # print(a)

        up = sum(a[0])
        low = sum(a[1])

        # colcopy = colsum[:]
        # for ele in colcopy:
        #     if ele==1:
        #         pass
        #     else:
        #         ele == 0
        
        # print(colsum)
        # print(colcopy)

        while up < upper:
            for i in range(len(a[0])):
                if colsum[i] == 1 and a[0,i] != 1:
                    a[0,i] = 1
                    up += 1
                    break
        # print(low,lower)
        while low < lower:
            for i in range(len(a[1])-1,0,-1):
                if colsum[i] == 1 and a[1,i] != 1:
                    a[1,i] = 1
                    low += 1
                    break
        # print(up,upper)

        return(a.astype(int))