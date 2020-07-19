from typing import List
from collections import deque

# pretty easy as well. Solved in 11 minutes first try
# solved 3/4 of the problems with 59 minutes to go in the contest. Might be a personal best
# collections.deque is pretty awesome
class Solution:
    def processQueries(self, queries: List[int], m: int) -> List[int]:

        deq = deque(range(1,m+1))
        # print(deq)
        res = []
        for que in queries:
            temp = deq.index(que)
            res.append(temp)
            deq.remove(que)
            deq.appendleft(que)
            # print(deq)
        print(res)
        return(res)



a = Solution()
# a.processQueries([3,1,2,1], 5)
# a.processQueries([4,1,2,2], 4)
a.processQueries([7,5,5,8,3],8)