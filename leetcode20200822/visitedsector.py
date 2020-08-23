from typing import List
from collections import defaultdict

### Accepted after 16 minutes. FIrst attempt rejected because output was not sorted
### Frustating easy problem with a 2 paragraph explanation

class Solution:
    def mostVisited(self, n: int, rounds: List[int]) -> List[int]:
        
        round_dict = defaultdict(int)
        
        for i in range(len(rounds)-1):
            start_place = rounds[i]
            end_place = rounds[i+1]
            curr_place = start_place
            for _ in range(100):
                # print(f"current place is {curr_place}")
                if curr_place == n:
                    round_dict[curr_place] += 1
                    curr_place = 1
                else:
                    round_dict[curr_place] += 1
                    curr_place += 1

                if curr_place == end_place:
                    break
        round_dict[curr_place] += 1

        # print(round_dict)

        round_list = [(k,v) for k,v in round_dict.items()]
        max_occ = max([occ[1] for occ in round_list])
        # print(round_list)

        all_max_occs = [x[0] for x in round_list if x[1] == max_occ]
        all_max_occs.sort()
        # print(all_max_occs)
        return all_max_occs

a = Solution()
# a.mostVisited(n = 4, rounds = [1,3,1,2])
# a.mostVisited(n = 2, rounds = [2,1,2,1,2,1,2,1,2])
# a.mostVisited(n = 7, rounds = [1,3,5,7])
a.mostVisited(n=3, rounds=[3,2,1,2,1,3,2,1,2,1,3,2,3,1])