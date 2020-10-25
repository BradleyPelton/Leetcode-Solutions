from typing import List

# First attempt time limit exceeded
# Switching to arraygame2

## Second attempt typo
# Third attempt accepted. Nice optimization. Time space complexity = O(n) , a single iteration

class Solution:
    def getWinner(self, arr: List[int], k: int) -> int:
        """ """

        if k > len(arr):
            print("returning max")
            print(max(arr))
            return max(arr)

        win_count = 0
        current_winner = arr[0]
        for i in range(1,len(arr)):
            # print(current_winner, arr[i])
            if arr[i] > current_winner:
                current_winner = arr[i]
                win_count = 1
            else:
                win_count += 1
            
            if win_count == k:
                break
        
        print(f"game ended. winner is {current_winner}, arr is {arr}")
        return current_winner

a = Solution()
a.getWinner(arr = [2,1,3,5,4,6,7], k = 2)
a.getWinner(arr = [3,2,1], k = 10)
a.getWinner(arr = [1,9,8,2,3,7,6,4,5], k = 7)
a.getWinner(arr = [1,11,22,33,44,55,66,77,88,99], k = 1000000000)