from typing import List

# sloppy work. I mangled the edge case where there is a tuple with sum = total_sum/2
class contests2020q4.leetcode20201017.Solution:
    def minSubsequence(self, nums: List[int]) -> List[int]:
        
        nums.sort()
        # print(nums)

        nums_tuples = []
        
        temp_sum = 0
        for i in range(len(nums)):
            temp_sum += nums[i]
            nums_tuples.append( (nums[i], temp_sum))
        print(nums_tuples)

        total_sum = temp_sum

        # for i in range(len(nums_tuples)):
        #     if nums_tuples[i][1] > total_sum/2 - 1:
        #         cutoff = nums_tuples[i][0]
        #         # print(nums_tuples[i])
        #         break

        ans = [a[0] for a in nums_tuples if a[1] > total_sum//2 -1]
        ans.sort()
        ans.reverse()
        print(ans)
        return(ans)


a = contests2020q4.leetcode20201017.Solution()
# a.minSubsequence([4,3,10,9,8])
# a.minSubsequence([4,4,7,6,7])
# a.minSubsequence([6])
# a.minSubsequence([4,3,10,9,8])
# a.minSubsequence([7,4,2,8,1,7,7,10])
a.minSubsequence([1,7,4,7,1,9,4,8,8])