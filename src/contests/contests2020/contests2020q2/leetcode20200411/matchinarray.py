from typing import List'

# Wasted 13 minutes on this problem. I didnt account for the edge case where
# some word, e.g.  'od' , was contained in MULTIPLE other words
# and it was double counting 'od'. list(set(res)) elimated that.
class contests2020q4.leetcode20201017.Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        res = []
        for i in range(len(words)):
            for j in range(len(words)):
                # print(words[i], words[j])
                if i != j and words[i] in words[j] and words[i] != words[j]:
                    res.append(words[i])
                    # print("found a match", words[i], words[j])
        # print(res)
        return(list(set(res)))


a = contests2020q4.leetcode20201017.Solution()
# a.stringMatching(["mass","as","hero","superhero"])
a.stringMatching(["leetcoder","leetcode","od","hamlet","am"])