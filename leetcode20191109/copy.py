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
        
        for col in colsum:
            if col == 2:
                a[0,col] = 1
                a[1,col] = 1
        # print(a)

        up = 0
        low = 0

        while up < upper:
            for i in range(len(a[0])):
                if a[0,i] == 0:
                    a[0,i] += 1
                    up = sum(a[0])
                    break
        # print(a)
        # print(up,upper)

        while low < lower :
            for i in range(len(a[1])-1,0,-1):
                if a[1,i] == 0:
                    a[1,i] += 1
                    low = sum(a[1])
                    break
        # print(a)
        # print(low,lower)
        return(a.astype(int))