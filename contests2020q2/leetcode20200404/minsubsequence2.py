from typing import List

# this solution was much cleaner. Accepted second try after adding <= to < line 15. Still sloppy 
class contests2020q4.leetcode20201017.Solution:
    def minSubsequence(self, nums: List[int]) -> List[int]:
        
        nums.sort()
        # print(nums)


        total_sum = sum(nums)

        ans = []
        current_sum = 0
        while current_sum <= total_sum/2:
            popped = nums.pop()
            ans.append(popped)
            current_sum += popped
            print(current_sum)
        
        print(ans)
        return(ans)

            



a = contests2020q4.leetcode20201017.Solution()
# a.minSubsequence([4,3,10,9,8])
# a.minSubsequence([4,4,7,6,7])
# a.minSubsequence([6])
# a.minSubsequence([4,3,10,9,8])
# a.minSubsequence([7,4,2,8,1,7,7,10])
a.minSubsequence([1,7,4,7,1,9,4,8,8])