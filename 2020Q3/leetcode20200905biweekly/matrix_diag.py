from typing import List


### Accepted after 6 minutes first try
### I'm sure there was a cleaner way of doing this, but this is the first thing that came to mind
### Should I be studying numpy for these types of problems? probably

class Solution:
    def diagonalSum(self, mat: List[List[int]]) -> int:
        

        left_sum = 0
        already_used = []
        for i in range(len(mat[0])):
            left_sum += mat[i][i]
            already_used.append((i,i))
        
        right_sum = 0
        for j in range(len(mat[0])-1,-1,-1):
            target_element = mat[len(mat) - 1 -j][j]
            # print(target_element)
            if (len(mat) - 1 - j, j) in already_used:
                pass
            else:
                right_sum += target_element

        # print(left_sum, right_sum, left_sum+right_sum)

        ans = left_sum + right_sum
        print(ans)
        return ans


a = Solution()
a.diagonalSum(mat = [[1,2,3],
              [4,5,6],
              [7,8,9]])

a.diagonalSum(mat = [[1,1,1,1],
              [1,1,1,1],
              [1,1,1,1],
              [1,1,1,1]])

a.diagonalSum(mat = [[5]])