from typing import List
class Solution:
    def maxNumberOfFamilies(self, n: int, reservedSeats: List[List[int]]) -> int:

        first_location = [2,3,4,5]
        second_locaion = [4,5,6,7]
        third_locaion = [6,7,8,9]
        possiblities = 0

        for i in range(1,n+1):
            ith_row_reserved = [res[1] for res in reservedSeats if res[0] == i]
            first = False
            second = False
            third = False
            # first
            for j in first_location:
                if j in ith_row_reserved:
                    break
            else:
                # print(f"first location for i= {i}")
                possiblities += 1
                first = True
            # third 
            for j in third_locaion:
                if j in ith_row_reserved:
                    break
            else:
                # print(f"third location for i= {i}")
                possiblities += 1
                third = True

            #second and not first and not third
            if not first and not third:
                for j in second_locaion:
                    if j in ith_row_reserved:
                        break
                else:
                    # print(f"second location for i = {i} AND NOT FIRST OR THIRD")
                    possiblities += 1

        print(possiblities)
        return(possiblities)

a = Solution    
a.maxNumberOfFamilies(a,n=3, reservedSeats=[[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]] )
a.maxNumberOfFamilies(a,2, [[2,1],[1,8],[2,6]])
a.maxNumberOfFamilies(a,4,[[4,3],[1,4],[4,6],[1,7]])