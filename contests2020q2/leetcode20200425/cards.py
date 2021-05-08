from typing import List
class contests2020q4.leetcode20201017.Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        """ """
        # [ LEFT_BLOCK, MID_BLOCK, RIGHT_BLOCK]
        # To maximize left_block + right_block, it is sufficient to minimize mid_block
        # since left + mid + right = sum(cardPoints)

        global_min = 9999999999999999999999999999999999999999
        corre_max = 0

        # taking k cards, means we have y cards leftover where y is equal to
        y = len(cardPoints) - k
        print(y)
        print(len(cardPoints))

        # for i in range(len(cardPoints)-y):
        #     temp_sum = sum(cardPoints[i:i+y+1])
        #     # print(f" asdfkjasldfjk {cardPoints[i:i+y+1]}")
        #     if temp_sum < global_min:
        #         print(f"found a local min with {cardPoints[i:i+y+1]} and {temp_sum}")
        #         print(cardPoints[0:i])
        #         print(cardPoints[i+y+1:])
        #         corre_max = sum(cardPoints[0:i]) + sum(cardPoints[i+y+1:])
        #         global_min = temp_sum
        # # print(cardPoints)
        # print(corre_max)

        abc = [
            cardPoints[i:i+y] for i in range(len(cardPoints))
            if len(cardPoints[i:i+y]) == y
        ]
        print(abc)

        sums = [sum(sublist) for sublist in abc]

        min_sublist = [sublist for sublist in abc if sum(sublist) == min(sums)]
        print(min_sublist)

        return(sum(nums) - min_sublist[0])
        
        # ab = [a for a in abc if len(a) == y]
        # print(ab)


a = contests2020q4.leetcode20201017.Solution()
a.maxScore([1,2,3,4,5,6,1], 3)
