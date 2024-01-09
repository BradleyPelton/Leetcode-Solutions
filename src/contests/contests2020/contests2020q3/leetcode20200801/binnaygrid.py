from typing import List

# Misread the problem. I thought it as number of element swaps... not row swaps. This is just RREF
# Switching to binarygrid2


class contests2020q4.leetcode20201017.Solution:
    def minSwaps(self, grid: List[List[int]]) -> int:
        

        number_of_ones_above_main_diagonal = 0
        for i in range(len(grid)):
            number_of_ones_above_main_diagonal += grid[i][i+1:].count(1)
        # print(number_of_ones_above_main_diagonal)
        # print(f"number of ones above the main diagonal is {number_of_ones_above_main_diagonal}")

        current_diagonal = []
        for i in range(len(grid)):
            current_diagonal.append(grid[i][i])
        ones_in_diagonal = current_diagonal.count(1)
        print(f"diagonal before is {current_diagonal}")
        # print(f"number of ones in diagonal is {ones_in_diagonal}")

        if number_of_ones_above_main_diagonal + ones_in_diagonal > len(grid):
            print("too many ones edge case")
            print(-1)
            return -1

        total_swaps = 0
        for x in range(len(grid)):
            for y in range(x+1,len(grid)):
                # print(f"(x,y) is {(x,y)}, and its value is {grid[x][y]}")
                if grid[x][y] == 1:
                    print(f"found a one at {(x,y)}")



                    # We need to find the nearest zero in the diagonal
                    if current_diagonal[x] == 0:
                        nearest_zero_index = x
                    elif current_diagonal[y] == 0:
                        nearest_zero_index = y
                    else:
                        for offset in range(0, len(grid)):
                            if current_diagonal[x + offset] == 0:
                                nearest_zero_index = x + offset
                            elif current_diagonal[x - offset] == 0:
                                nearest_zero_index = x - offset
                            elif current_diagonal[y + offset] == 0:
                                nearest_zero_index = y + offset
                            elif current_diagonal[y - offset] == 0:
                                nearest_zero_index = y - offset


                    # Now that we have the nearest zero, count steps and change diagonal
                    number_of_steps = (x - nearest_zero_index) + (y - nearest_zero_index)
                    current_diagonal[nearest_zero_index] = 1
                    print(current_diagonal)
                    print(f" adding {number_of_steps} steps to total")



a = contests2020q4.leetcode20201017.Solution()
a.minSwaps(grid = [[0,0,1],[1,1,0],[1,0,0]])
# a.minSwaps(grid = [[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,1,1,0]])
# a.minSwaps(grid = [[1,0,0],[1,1,0],[1,1,1]])
            