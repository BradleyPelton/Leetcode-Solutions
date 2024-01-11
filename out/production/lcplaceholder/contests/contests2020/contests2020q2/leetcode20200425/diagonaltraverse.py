from typing import List
# First attempt time limit exceeded. switching to diagonal2
class contests2020q4.leetcode20201017.Solution:
    def findDiagonalOrder(self, nums: List[List[int]]) -> List[int]:
        """ """

        output_list = []


        x_length= len(nums)  # Represents the number of rows
        y_length = max(len(row) for row in nums)  # Represents the max number of columns

        MAX_NUMBER_OF_DIAGONALS = x_length + y_length
        # Each element gets its own diagonal, top and right column

        # 0,0
        # 1,0 , 0,1
        # 2,0 1,2 0,2
        # 3,0 2,1 1,2 0,3

        for i in range(MAX_NUMBER_OF_DIAGONALS):
            # print(i)
            x = 0
            y = i 
            while x < i+1:
                # print(x,y)
                try:
                    output_list.append(nums[y][x])
                except IndexError:
                    pass
                x += 1
                y -= 1
        # print(output_list)
        return(output_list)

a = contests2020q4.leetcode20201017.Solution()
# a.findDiagonalOrder([[1,2,3],[4,5,6],[7,8,9]])
# a.findDiagonalOrder([[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]])
# a.findDiagonalOrder([[1,2,3],[4],[5,6,7],[8],[9,10,11]])
a.findDiagonalOrder([[1,2,3,4,5,6]])