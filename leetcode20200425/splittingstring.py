from collections import deque

# accepted first try. 11 minutes. deque was very useful, as always
class Solution:
    def maxScore(self, s: str) -> int:
        """ """

        max_score = 0

        left_str = deque(s[:-1])
        right_str = deque(s[-1])
        # print(left_str)
        # print(right_str)
        while len(left_str) > 0:
            current_score = left_str.count('0') + right_str.count('1')
            if current_score > max_score:
                max_score = current_score
                # print(f"found a max score of {max_score} with {left_str} and {right_str}")
            left_pop = left_str.pop()
            right_str.appendleft(left_pop)
            # print(left_str,right_str)
        print(max_score)
        return(max_score)

a = Solution()
a.maxScore('00111')
