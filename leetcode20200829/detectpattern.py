from typing import List

## Accepted after 13 minutes. Dificult easy problem. Only 900 people finished before 13 minutes
## FIrst attempt was rejected because I limited the arra on line 15 too short. range(len(arr)) instead of range(len(arr)-sub_arr_size)

class Solution:
    def containsPattern(self, arr: List[int], m: int, k: int) -> bool:
        
        # if len(arr) == 2:

        
        sub_arr_size = m*k
        

        for i in range(len(arr)):
            temp_arr = arr[i:i+sub_arr_size]
            print(temp_arr, temp_arr[0:m])
            if temp_arr == temp_arr[0:m]*k:
                print(f"found a solution, temp_arr")
                return True
        print("no solution found")
        return False

a = Solution()
# a.containsPattern(arr = [1,2,4,4,4,4], m = 1, k = 3)  ## Expected true
# a.containsPattern([1,2,1,2,1,1,1,3], m = 2, k = 2)  ## Expected True
# a.containsPattern(arr = [1,2,1,2,1,3], m = 2, k = 3)  ## Expected False
# a.containsPattern(arr = [1,2,3,1,2], m = 2, k = 2)  # Expected False
# a.containsPattern(arr = [2,2,2,2], m = 2, k = 3)  # Expected False


a.containsPattern(arr=[2,2],m=1,k=2)  # Expected True


