from typing import List


class contests2020q4.leetcode20201017.Solution:
    def minSwaps(self, grid: List[List[int]]) -> int:
        """ """




        # if it is possible at all, then the sort by "row reduced echeleon form" sort


        row_list = []
        for i in range(len(grid)):
            row_list.append([i, len(grid) - 1 - grid[i][::-1].index(1)])
        print(row_list)

        # [(0, 2), (1, 1), (2, 0)]
        # [ (i-th row, last_one_index)]
        # for each row, the last_one_index <= i


        for _ in range(10):
            for j in range(len(grid)):
                if row_list[j][1] > j:
                    # swap the jth row with the j+1th row
                    temp = 
                    row_list[j][0] += 1
                    row_list[j+1][0] -= 1

                print(f" row list after a swap {row_list}")





















        # number_of_ones_above_main_diagonal = 0
        # for i in range(len(grid)):
        #     number_of_ones_above_main_diagonal += grid[i][i+1:].count(1)
        # # print(number_of_ones_above_main_diagonal)
        # # print(f"number of ones above the main diagonal is {number_of_ones_above_main_diagonal}")

        # current_diagonal = []
        # for i in range(len(grid)):
        #     current_diagonal.append(grid[i][i])
        # ones_in_diagonal = current_diagonal.count(1)
        # print(f"diagonal before is {current_diagonal}")
        # # print(f"number of ones in diagonal is {ones_in_diagonal}")

        # if number_of_ones_above_main_diagonal + ones_in_diagonal > len(grid):
        #     print("too many ones edge case")
        #     print(-1)
        #     return -1

        # total_swaps = 0
        # for x in range(len(grid)):
        #     for y in range(x+1,len(grid)):



a = contests2020q4.leetcode20201017.Solution()
a.minSwaps(grid = [[0,0,1],[1,1,0],[1,0,0]])
# a.minSwaps(grid = [[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,1,1,0]])
# a.minSwaps(grid = [[1,0,0],[1,1,0],[1,1,1]])
            