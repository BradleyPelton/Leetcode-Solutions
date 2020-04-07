from typing import List
# misread the question. Very poor wording by Leetcode for the distance function
class Solution:
    def findTheDistanceValue(self, arr1: List[int], arr2: List[int], d: int) -> int:
        
        # arr1.sort()
        # arr2.sort()
        """The distance value is defined as the number of elements arr1[i] 
        such that there is not any element arr2[j] where |arr1[i]-arr2[j]| <= d."""
        distance = 0

        # there is probably an elegant solution here
        # would rather work on medium problems
        for i in range(len(arr1)):
            matching_ele = 0
            for j in range(len(arr2)):
                if abs(arr1[i]-arr2[j]) <= d:
                    matching_ele += 1
            if matching_ele == 0:
                distance += 1
        print(distance)
        return(distance)


a = Solution()
a.findTheDistanceValue([1,4,2,3],[-4,-3,6,10,20,30],3)
a.findTheDistanceValue([4,5,8],[10,9,1,8],2)

                

