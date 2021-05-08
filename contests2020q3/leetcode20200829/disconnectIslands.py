from typing import List


## Switching to disconnectislands2.py

class contests2020q4.leetcode20201017.Solution:
    def minDays(self, grid: List[List[int]]) -> int:
        """ """
        grid_copy = grid[:]
        def dfs(grid, i, j):
            if i<0 or j<0 or i>=len(grid) or j>=len(grid[0]) or grid[i][j] != 1:
                return
            grid[i][j] = '#'
            dfs(grid, i+1, j)
            dfs(grid, i-1, j)
            dfs(grid, i, j+1)
            dfs(grid, i, j-1)

        def numIslands(grid):
            if not grid:
                return 0
            count = 0
            for i in range(len(grid)):
                for j in range(len(grid[0])):
                    if grid[i][j] == 1:
                        dfs(grid, i, j)
                        count += 1
            return count





        before_count = numIslands(grid)
        print(f"before count was {before_count}")

        if before_count > 1:
            print("already two island edge case")
            return 0

        grid = grid_copy
        penisula_candidates = []
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                print(grid[i][j])
                if grid[i][j] == 1:
                    land_adjs = 0
                    try:
                        if grid[i+1][j] == 1:
                            land_adjs += 1
                    except IndexError:
                        pass
                    try:
                        if grid[i-1][j] == 1:
                            land_adjs += 1
                    except IndexError:
                        pass
                    try:
                        if grid[i][j+1] == 1:
                            land_adjs += 1
                    except IndexError:
                        pass
                    try:
                        if grid[i+1][j-1] == 1:
                            land_adjs += 1
                    except IndexError:
                        pass

                    print(f"land ads is {land_adjs}")

                    if land_adjs == 1:
                        print("found a perfect penisula")
                        return 1
                    elif land_adjs == 2:
                        penisula_candidates.append((i,j))

        print(f"found pen cands {penisula_candidates}")
        for candidate in penisula_candidates:
            temp_grid = grid[:]
            temp_grid[candidate[0]][candidate[1]] = 0
            print(temp_grid)
        

        ## THEORY: THE ANSWER IS ALWAYS LESS THAN OR EQUAL TO 2 

        ### IF ISLAND HAS PENISULA
        # Remove the nearest land tile to the penisula.
        # Rerun the count for number of islands. If number of islands is still 1, return 2

        ### If not, answer = 2

a = contests2020q4.leetcode20201017.Solution()
# a.minDays(grid = [[0,1,1,0],[0,1,1,0],[0,0,0,0]])
# a.minDays(grid = [[1,0,1,0]])
a.minDays(grid = [[1,1,0,1,1],
               [1,1,1,1,1],
               [1,1,0,1,1],
               [1,1,1,1,1]])