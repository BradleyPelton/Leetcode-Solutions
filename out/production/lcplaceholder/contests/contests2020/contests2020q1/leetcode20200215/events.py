from typing import List
from collections import defaultdict
class contests2020q4.leetcode20201017.Solution:
    def maxEvents(self, events: List[List[int]]) -> int:
        # GREEDY. AT ANY GIVEN TIME, JUST ATTEND THE SHORTEST EVENT
        

        eventsdict = defaultdict(list)
        for interval in events:
            eventsdict[interval[0]].append(interval[1])
        # print(eventsdict)

        for _,val in eventsdict.items():
            val.sort()
        print(eventsdict)

        last_day  = max([interval[1] for interval in events])
        # print("last day is ", last_day)

        current_time = 1
        count = 0
        while current_time < last_day:
            count += 1
            print(current_time)
            shortest_event = eventsdict[current_time][0]
            current_time += eventsdict[current_time][0] - current_time
            eventsdict[current_time].remove(shortest_event)
            print(eventsdict[current_time])
        print(count)




a = contests2020q4.leetcode20201017.Solution()
a.maxEvents([[1,4],[4,4],[2,2],[3,4],[1,1]])     
