from typing import List


class Solution:
    def maxDistance(self, position: List[int], m: int) -> int:
        ### Theory: Spread the balls out as far as possible from each other.

        pos_copy = position[:]
        pos_copy.sort()

        current_val = pos_copy[0]
        balls_placed = 1
        pos_sum = sum(pos_copy)
        avg_dist = pos_sum/m

        placements = [pos_copy[0]]

        print("before starting values")
        print(f"pos_sum is {pos_sum}")
        print(f"avg_dist is {avg_dist} \n")

        for i in range(len(position)):
            print(f"current bin is {pos_copy[i]}")

            ### If we overshot the projected value
            if pos_copy[i] >= current_val + avg_dist:
                placements.append(pos_copy[i-1])
                print(placements)
                balls_placed += 1

                current_val = pos_copy[i-1]

                pos_copy = pos_copy[i:]
                pos_sum = sum(pos_copy)
                avg_dist = (m - balls_placed)/pos_sum


            # exit condition
            if len(placements) == m - 1:
                placements.append(pos_copy[-1])
                print(placements)
                break

a = Solution()
a.maxDistance(position = [1,2,3,4,7], m = 3)