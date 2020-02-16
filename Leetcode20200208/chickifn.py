from typing import List

class Solution:
    def checkIfExist(self, arr: List[int]) -> bool:
        arr.sort()

        for i in range(len(arr)):
            for j in range(len(arr)):
                if arr[i] * 2 == arr[j] and i != j:
                    return True
        return False

a = Solution()

print(a.checkIfExist([10,2,5,3]))
print(a.checkIfExist([7,1,14,11]))

print(a.checkIfExist([3,1,7,11]))


