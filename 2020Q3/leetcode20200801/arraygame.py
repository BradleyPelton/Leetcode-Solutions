from typing import List

# First attempt time limit exceeded
# Switching to arraygame2

class Solution:
    def getWinner(self, arr: List[int], k: int) -> int:
        """ """

        if k > len(arr):
            print("returning max")
            print(max(arr))
            return max(arr)

        win_count = 0
        for _ in range(len(arr)+1):
            if arr[0] > arr[1]:
                win_count += 1
                arr = [arr[0]] + arr[2:] + [arr[1]]
            else:
                win_count = 1
                arr = [arr[1]] + arr[2:] + [arr[0]]
            # print(f"arr after round {_} is {arr}")

            if win_count == k:
                break
        
        print(f"game ended. winner is {arr[0]}, arr is {arr}")
        return arr[0]

a = Solution()
a.getWinner(arr = [2,1,3,5,4,6,7], k = 2)
a.getWinner(arr = [3,2,1], k = 10)
a.getWinner(arr = [1,9,8,2,3,7,6,4,5], k = 7)
a.getWinner(arr = [1,11,22,33,44,55,66,77,88,99], k = 1000000000)