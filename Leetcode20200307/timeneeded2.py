from typing import List


# ohhhhhh I didnt understand the question entirely
# if the manager informs 3 people
# and all 3 of those people are managers
# those three people willl simultaneously start informing their employees


# this is a simple graph theory problem
# we need to find the path in graph that has the longest time
# that longest time is the answer to this question

# study more graph theory for these types of problems
# I also spent too much time on the bulb problem. I miht have figured this one out
class Solution:
    def numOfMinutes(self, n: int, headID: int, manager: List[int], informTime: List[int]) -> int:
        
        distinct_manager = list(set(manager))
        distinct_manager.remove(-1)
        print(distinct_manager)

        total_minutes = 0
        for manager in distinct_manager:
            total_minutes += informTime[manager]
        print(total_minutes)

a = Solution()
# a.numOfMinutes(6,2,[2,2,-1,2,2,2],[0,0,1,0,0,0])

# # #n = 7, headID = 6, manager = [1,2,3,4,5,6,-1], informTime = [0,6,5,4,3,2,1]
# a.numOfMinutes(7,6,[1,2,3,4,5,6,-1],[0,6,5,4,3,2,1]) #  my ans was 22, correct ans was 21

# n = 15, headID = 0, manager = [-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6], informTime = [1,1,1,1,1,1,1,0,0,0,0,0,0,0,0]
a.numOfMinutes(15,0,[-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6],[1,1,1,1,1,1,1,0,0,0,0,0,0,0,0])