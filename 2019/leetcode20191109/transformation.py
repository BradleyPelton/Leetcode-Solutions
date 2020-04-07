import numpy as np
from typing import List
class Solution:
    def oddCells(self, n: int, m: int, indices: List[List[int]]) -> int:
        # indices[i] = [ri, ci]. increment all elements in row r_i and column c_i
        a = np.zeros((n,m))
        print(a)
        for pair in indices:
            print(pair)
            a[pair[0]] = a[pair[0]] + 1
            a[:,pair[1]] = a[:,pair[1]] + 1

        print(a)
        a = a % 2
        return(int(a.sum()))
