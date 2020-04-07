from collections import defaultdict
from typing import List
class Solution:
    def rankTeams(self, votes: List[str]) -> str:
        
        number_of_votes = len(votes[0])
        results_dict = defaultdict()

        for i in range(number_of_votes):
            results_dict[i]  = defaultdict(int)

        for vote in votes:
            for i in range(len(vote)):
                # i is the round 
                results_dict[i][vote[i]] += 1
        print(results_dict)


        # another_dict = defaultdict(list)
        
        ans = []

        for round_number, round_dict in results_dict.items():
            for key,val in round_dict.items():
                print("round number", round_number)
                print(key,val)
                # ans.append


        # desired result
        # a votes = [5,0,0] b votes [0,2,3]




a = Solution()
a.rankTeams(["ABC","ACB","ABC","ACB","ACB"])