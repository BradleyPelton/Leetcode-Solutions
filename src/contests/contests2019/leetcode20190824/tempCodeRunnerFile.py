
# class contests2020q4.leetcode20201017.Solution:
#     def numSmallerByFrequency(self, queries: List[str], words: List[str]) -> List[int]:
#         answer = []
#         for word in queries:
#             count = 0
#             word_score = eff(word)
#             for w in words:
#                 if word_score < eff(w):
#                     count += 1
#             answer.append(count)
#         return(answer)
