from typing import List


# I misread the problem. I thought it wanted max dot product of any combo.
# It actually wants SUBSEQUENCE, so the sequence has to be respected.
# I was jsut finding the smallest and largest and multiplying them together.
# Didnt have too much time after the binary tree problem. I'm not solving my first hard
# with just 30 minutes haha. Fun to attempt at least
class Solution:
    def maxDotProduct(self, nums1: List[int], nums2: List[int]) -> int:
        """ """
        a_nums = nums1
        b_nums = nums2

        a_negatives = [i for i in a_nums if i < 0]
        b_negatives = [i for i in b_nums if i < 0]
        # print(f"a negatives {a_negatives}")
        # print(f"b negatives {b_negatives}")

        a_positives = [i for i in a_nums if i > 0]
        b_positives = [i for i in b_nums if i > 0]
        # print(f"a postiives {a_positives}")
        # print(f"b positives  {b_positives}")

        positive_pairs = min(len(a_positives), len(b_positives))
        negative_pairs = min(len(a_negatives), len(b_negatives))

        # print(f"number of positive pairs is {positive_pairs}")
        # print(f"number of negative pairs is {negative_pairs}")

        a_negatives.sort(reverse=True)
        a_positives.sort(reverse=True)
        b_negatives.sort(reverse=True)
        b_positives.sort(reverse=True)

        total_sum = 0
        for j in range(negative_pairs):
            total_sum += a_negatives[j] * b_negatives[j]
            print(total_sum)

        for j in range(positive_pairs):
            print(a_positives[j], b_positives[j])
            total_sum += a_positives[j] * b_positives[j]
            print(total_sum)




a = Solution()
a.maxDotProduct([2,1,-2,5], [3,0,-6])
