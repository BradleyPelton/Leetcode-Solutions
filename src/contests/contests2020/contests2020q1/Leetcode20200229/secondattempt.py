from collections import defaultdict
from typing import List

# FUMBLED AROUND WITH DEFAULTDICT FOR AN HOUR
# AND DIDNT READ THE INSTRUCTIONS THAT ALL TEAMS WERE TO BE RANKED
# NOT JUST THE WINNERS
# POTENTIAL_WINNERS IS ALL WRONG
class contests2020q4.leetcode20201017.Solution:
    def rankTeams(self, votes: List[str]) -> str:

        number_of_votes = len(votes[0])

        vote_dict = defaultdict(list)
        for i in range(len(votes[0])):
            for vote in votes:
                vote_dict[i].append(vote[i])

        potential_winners = list(set(vote_dict[0]))
        print(potential_winners)


        base_list = [0]*number_of_votes
        ans_dict = defaultdict(list)
        for winner in potential_winners:
            ans_dict[winner] = base_list[:]
        # print(ans_dict)


        for round_number,round_results in vote_dict.items():
            for vote in round_results:
                if vote in potential_winners:
                    ans_dict[vote][round_number] += 1
        
        temp_list = [val + list(key) for key,val in ans_dict.items()]
        temp_list.reverse()
        
        ans_string = [mylist[-1] for mylist in temp_list]
        print("".join(ans_string))






a = contests2020q4.leetcode20201017.Solution()
a.rankTeams(["ABC","ACB","ABC","ACB","BCB"])