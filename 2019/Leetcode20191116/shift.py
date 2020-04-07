from typing import List
from collections import deque
class Solution:
    def shiftGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:

        def shift(grid):
            height = len(grid)
            width = len(grid[0])

            flat_list = [item for sublist in grid for item in sublist]
            # print(flat_list)

            copy = deque(flat_list)
            popped = copy.pop()
            copy.appendleft(popped)

            # print(list(copy))
            # print(flat_list)
            def divide_chunks(l, n): 
                # looping till length l 
                for i in range(0, len(l), n):  
                    yield l[i:i + n] 

            return(list(divide_chunks(list(copy),width)))
        
        if k == 1:
            return(shift(grid))
        else:
            for _ in range(0,k):
                grid = shift(grid)
        return(grid)


