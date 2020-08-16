from typing import List

## Accepted first try after 3 minutes. childs play


class Solution:
    def threeConsecutiveOdds(self, arr: List[int]) -> bool:
        
        current_count = 0

        for val in arr:
            if val%2 == 1:
                current_count += 1
            else:
                current_count = 0
            
            if current_count == 3:
                print("True")
                return True
        print("false")
        return False


a = Solution()
# a.threeConsecutiveOdds([2,6,4,1])
a.threeConsecutiveOdds([1,2,34,3,4,5,7,23,12])
