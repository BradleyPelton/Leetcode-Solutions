from typing import List
class Solution:
    def numOfMinutes(self, n: int, headID: int, manager: List[int], informTime: List[int]) -> int:
        # manager[i] is the direct manager of the i-th employee,
        # The i-th employee needs informTime[i] minutes to inform all of his direct subordinates

        # the idea:
        # at each stage, we find all employees who have manager
        # we remove those employees from the manager list
        # iterate until manager is empty

        total_minutes = 0
        #FIRST CASE , NEED A DO-WHILE LOOP THAT ALWAYS EXECUTE THE FIRST CASE
        total_minutes += informTime[headID]
        manager = [person for person in manager if person != headID]
        # print(headID, manager)

        while len(manager) > 0 :
            headID = manager[0]
            if headID == -1:
                manager = [person for person in manager if person != headID]
                continue
            total_minutes += informTime[headID]
            manager = [person for person in manager if person != headID]
        print(total_minutes)

        






a = Solution()
# a.numOfMinutes(6,2,[2,2,-1,2,2,2],[0,0,1,0,0,0])

# #n = 7, headID = 6, manager = [1,2,3,4,5,6,-1], informTime = [0,6,5,4,3,2,1]
# a.numOfMinutes(7,6,[1,2,3,4,5,6,-1],[0,6,5,4,3,2,1]) #  my ans was 22, correct ans was 21

# n = 15, headID = 0, manager = [-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6], informTime = [1,1,1,1,1,1,1,0,0,0,0,0,0,0,0]
a.numOfMinutes(15,0,[-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6],[1,1,1,1,1,1,1,0,0,0,0,0,0,0,0])
