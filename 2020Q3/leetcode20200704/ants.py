from typing import List
from collections import defaultdict

# first submission Wrong Answer. Strange...
# second submission wrong answer. Edge cases are killing me

class Solution:
    def getLastMoment(self, n: int, left: List[int], right: List[int]) -> int:
        """ n = 4, left = [4,3], right = [0,1] """

        ants = []
        for ant in left:
            ants.append([ant,'left'])
        for ant in right:
            ants.append([ant, 'right'])

        current_time = 0


        # Weird edge case where we started at a position that was already completed
        # if all ents are on the edge and pointing off the board
        unfinished_counter = 0
        for ant in ants:
            print(ant[0], ant[1])
            # if any ant is not finished, break
            if ant[0] != 0 and ant[0] != n:
                break
            if ant[0] == 0  and ant[1] == 'right':
                break
            if ant[0] == n and ant[1] == 'left':
                unfinished_counter += 1
                break
        else:
            # if loop finished, all ants are finished
            # print("weird edge case of already completed ants")
            return current_time



        # print("ants before starting ")
        # print(ants)
        # print("=-=-=-=-=-=-")
        # i represents the ith ant, ants[i] represents [POSITION, DIRECTION]

        while True:
            current_time += 1
            # print(f"current time value is {current_time}")

            # MOVE THE ANTS
            for i in range(len(ants)):
                if ants[i][1] == 'left':
                    ants[i][0] -= 1
                elif ants[i][1] == 'right':
                    ants[i][0] += 1
            
            # print(ants)
            
            # DETERMINE COLLISION
            current_positions = defaultdict(list)
            for j in range(len(ants)):
                current_positions[ants[j][0]].append(j)

            for position in current_positions.keys():
                if len(current_positions[position]) > 1:
                    # print(f"found an intersection at {position}")
                    # found an intersection
                    # print(f"current value of cur_pos = {current_positions[position]}")
                    for val in current_positions[position]:
                        if ants[val][1] == 'left':
                            ants[val][1] = 'right'
                        elif ants[val][1] == 'right':
                            ants[val][1] = 'left'
            
            # print(current_positions)

            # DETERMINE IF EDGE
            for k in range(1,n):
                if len(current_positions[k]) > 0:
                    break
                # print(f"found an ant still in the maze, at time {current_time}")
            else:
                # print(f"no ants are still remaining at time {current_time}")
                return current_time

a = Solution()
# a.getLastMoment(n = 4, left = [4,3], right = [0,1])  # expected val is 4
# a.getLastMoment(n = 7, left = [], right = [0,1,2,3,4,5,6,7])  # expected val is 7
# a.getLastMoment(n = 7, left = [0,1,2,3,4,5,6,7], right = [])  # expect val is 7
# a.getLastMoment(n = 9, left = [5], right = [4])  # expected val is 5
# a.getLastMoment(n = 6, left = [6], right = [0])  # expected val is 6
a.getLastMoment(n = 1000, left = [0], right = [])  # expected val is 0
a.getLastMoment(n = 54,
left = [1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,36,40,42,44,46,49,51,54],
right = [0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,34,37,41,43,45,48,50,53]
)
