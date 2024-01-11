from typing import List
# contests2020q4.leetcode20201017.Solution timed out. Means it correct, but it takes too long
class contests2020q4.leetcode20201017.Solution:
    def maxNumberOfFamilies(self, n: int, reservedSeats: List[List[int]]) -> int:
        """return the maximum number of four-person families you can allocate on the cinema seats. A four-person family occupies fours seats in one row, that are next to each other. Seats across an aisle (such as [3,3] and [3,4]) are not considered to be next to each other, however, It is permissible for the four-person family to be separated by an aisle, but in that case, exactly two people have to sit on each side of the aisle."""

        first_location = [2,3,4,5]
        second_locaion = [4,5,6,7]
        third_locaion = [6,7,8,9]
        possiblities = 0

        for i in range(1,n+1):
            first = False
            second = False
            third = False
            # first
            for j in first_location:
                if [i,j] in reservedSeats:
                    break
            else:
                # print(f"first location for i= {i}")
                possiblities += 1
                first = True
            # third 
            for j in third_locaion:
                if [i,j] in reservedSeats:
                    break
            else:
                # print(f"third location for i= {i}")
                possiblities += 1
                third = True

            #second and not first and not third
            if not first and not third:
                for j in second_locaion:
                    if [i,j] in reservedSeats:
                        break
                else:
                    # print(f"second location for i = {i} AND NOT FIRST OR THIRD")
                    possiblities += 1

        # print(possiblities)
        return(possiblities)

a = contests2020q4.leetcode20201017.Solution
# a.maxNumberOfFamilies(a,n=3, reservedSeats=[[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]] )
a.maxNumberOfFamilies(a,2, [[2,1],[1,8],[2,6]])
a.maxNumberOfFamilies(a,4,[[4,3],[1,4],[4,6],[1,7]])