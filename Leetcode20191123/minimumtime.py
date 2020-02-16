
from typing import List

class Solution:
    def minTimeToVisitAllPoints(self, points: List[List[int]]) -> int:
        pass

        
        def distance(node1,node2):
            # distance = 0
            vector = [node2[0]-node1[0],node2[1]-node1[1]] #[3,2] - [1,1] = [2,1]
            vector = [       abs(vector[0])  ,    abs(vector[1])     ]
            # print(vector)

            # mini = min(vector[0],vector[1])
            # print(mini)
            # distance += mini
            # distance += vector[0]-mini + vector[1]-mini
            # return(distance)

            return(max(vector[0],vector[1]))

        totaldistance = 0
        for i in range(len(points)-1):
            totaldistance += distance(points[i],points[i+1])
        return(totaldistance)
