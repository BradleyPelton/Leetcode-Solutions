from typing import List

# Accepted first attempt
# Accepted after 22 minutes. I over complicated this thinking I was going to have to 
# make some efficient algorithm. Simple find the largest x and largest y worked
class Solution:
    def maxArea(self, h: int, w: int, horizontalCuts: List[int], verticalCuts: List[int]) -> int:
        """ """
        m = 1000000007

        horizontalCuts.append(0)
        horizontalCuts.append(h)
        horizontalCuts.sort()
        h_ranges = [(horizontalCuts[i], horizontalCuts[i+1]) for i in range(len(horizontalCuts)-1)]

        # print(h_ranges)

        verticalCuts.append(0)
        verticalCuts.append(w)
        verticalCuts.sort()
        w_ranges = [(verticalCuts[i], verticalCuts[i+1]) for i in range(len(verticalCuts)-1)]

        # print(w_ranges)

        sorted_h_ranges = sorted(h_ranges, key=lambda x: x[1]-x[0])
        # print(sorted_h_ranges)

        sorted_w_ranges = sorted(w_ranges, key=lambda x: x[1]-x[0])
        # print(sorted_w_ranges)

        largest_width = sorted_w_ranges[-1][1] - sorted_w_ranges[-1][0]
        largest_height = sorted_h_ranges[-1][1] - sorted_h_ranges[-1][0]

        largest_slice = largest_width * largest_height
        print(largest_slice)
        return largest_slice % m


a = Solution()
# a.maxArea(5, 4, [1, 2, 4], [1, 3])
# a.maxArea( 5, 4, [3,1], [1])
a.maxArea(5, 4, [3],[3])