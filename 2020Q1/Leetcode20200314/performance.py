# MY FIRST ATTEMPT AT A LEETCODE HARD!!!!
# I should have just done the other medium proble, 
# but it was a binary tree question and I am stubborn about learning
# something that Is very niche to Leetcode




from collections import defaultdict
from typing import List
class Solution:
    def maxPerformance(self, n: int, speed: List[int], efficiency: List[int], k: int) -> int:
        # we are trying to maximize the performance( speed*efficiency ) for k workers
        # to maximize the sum of k workers, we need find the k most performant workers

        perf_dict = defaultdict(int)

        for i in range(n):
            perf_dict[i] = speed[i]*efficiency[i]

        print(perf_dict)
        sorted_perf = {k: v for k, v in sorted(perf_dict.items(), key=lambda item: item[1])}
        print(sorted_perf)
        print(list(sorted_perf))
        # pop_list = list(sorted_perf)
        # ans = []
        # print(sorted_perf.pop())

a = Solution()
# n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 2
a.maxPerformance(6,[2,10,3,1,5,8],[5,4,3,9,7,2],2)