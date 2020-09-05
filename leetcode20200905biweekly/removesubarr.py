from typing import List


class Solution:
    def findLengthOfShortestSubarray(self, arr: List[int]) -> int:
        """ """

        first_occ = 0
        last_occ = 0
        print(arr)
        for i in range(1,len(arr)):
            if arr[i-1] > arr[i]:
                if first_occ == 0:
                    first_occ = i
                else: 
                    last_occ = i
        
        if first_occ == last_occ == 0:
            print("already non-decreasing")
            return 0
        

        print(first_occ, arr[first_occ])
        print(last_occ, arr[last_occ])

        pre_occ = arr[first_occ-2]
        print(pre_occ)

        new_arr = arr[:first_occ-1] + arr[last_occ+1:]
        print(new_arr)

        # [ 1,2,3,5,         FIRST_OCC , .... , LAST_OC, ...., n]
        # Obviously we need to cut everything between FIRST_OCC and LAST_OCC
        #

a = Solution()
# a.findLengthOfShortestSubarray(arr = [1,2,3,10,4,2,3,5])
a.findLengthOfShortestSubarray(arr = [1,2,3,10,8,1,2,2,2,2,3,5])
