from typing import List
class contests2020q4.leetcode20201017.Solution:
    def maxNumberOfFamilies(self, n: int, reservedSeats: List[List[int]]) -> int:
        """return the maximum number of four-person families you can allocate on the cinema seats. A four-person family occupies fours seats in one row, that are next to each other. Seats across an aisle (such as [3,3] and [3,4]) are not considered to be next to each other, however, It is permissible for the four-person family to be separated by an aisle, but in that case, exactly two people have to sit on each side of the aisle."""

        first_location = [2,3,4,5]
        second_locaion = [4,5,6,7]
        third_locaion = [6,7,8,9]


        possiblities = 0
        for i in range(1,n+1):
            
            # annoying condition: double counting 1,2,3 location allowed
            # if the entire row is open, only 2 different families
            # even though 3 slots are available for families 

            first = False
            second = False
            third = False


            for j in first_location:
                if [i,j] in reservedSeats:
                    break
            else:
                print(f"first location for i= {i}")
                possiblities += 1
                first = True

            for j in third_locaion:
                if [i,j] in reservedSeats:
                    break
            else:
                print(f"third location for i= {i}")
                possiblities += 1
                third = True
        
            for j in second_locaion:
                if[i,j] in reservedSeats:
                    break
            else:
                if first and third:
                    print("first and third already available, dont count second")
                    pass
                else:
                    print(f"second location for i= {i}")
                    possiblities += 1
                    second = True
        print(possiblities)
        return(possiblities)


a = contests2020q4.leetcode20201017.Solution
# a.maxNumberOfFamilies(a,n=3, reservedSeats=[[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]] )
a.maxNumberOfFamilies(a,2, [[2,1],[1,8],[2,6]])
                

