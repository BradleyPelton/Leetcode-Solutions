from typing import List
# Solved in 4 minutes. straightforward
class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        
        current_max =  max(candies)

        bool_list = []

        for kid in candies:
            if kid + extraCandies >= current_max:
                bool_list.append(True)
            else:
                bool_list.append(False)
        print(bool_list)
        return(bool_list)


a = Solution()
a.kidsWithCandies([2,3,5,1,3], 3)
a.kidsWithCandies([4,2,1,1,2], 1)
a.kidsWithCandies([12,1,12],10)