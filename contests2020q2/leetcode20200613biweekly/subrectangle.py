from typing import List

# First attempt output limit exeeded, forgot to comment out the prints
# accepted after second attempt. Completed after 22 minutes... took way too long.
# List comprehension hiccup again with mid_section
class SubrectangleQueries:

    def __init__(self, rectangle: List[List[int]]):
        self.rectangle = rectangle

    def updateSubrectangle(self, row1: int, col1: int, row2: int, col2: int, newValue: int) -> None:
        """ """
        for i in range(len(self.rectangle)):
            if i >= row1 and i <= row2:
                row_copy = self.rectangle[i][:]
                # print(f"row before {row_copy}")
                mid_section = [newValue for _ in range(col2 - col1 + 1)]
                # print(f"mid section is {mid_section}")
                altered_row = row_copy[:col1] + mid_section + row_copy[col2 + 1:]
                self.rectangle[i] = altered_row
                # print(f"row after {altered_row}")

    def getValue(self, row: int, col: int) -> int:
        return self.rectangle[row][col]


# Your SubrectangleQueries object will be instantiated and called as such:
# obj = SubrectangleQueries(rectangle)
# obj.updateSubrectangle(row1,col1,row2,col2,newValue)
# param_2 = obj.getValue(row,col)

obj = SubrectangleQueries([[1,2,1],[4,3,4],[3,2,1],[1,1,1]])
print(obj.rectangle)
print(obj.getValue(0, 2))
obj.updateSubrectangle(0, 0, 3, 2, 5)
print(obj.getValue(0, 2))
print(obj.getValue(3, 1))
# 
obj.updateSubrectangle(3, 0, 3, 2, 10)
print(obj.getValue(3, 1))
print(obj.getValue(0, 2))

# print("________________________")
# print(obj.rectangle)