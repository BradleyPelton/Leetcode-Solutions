from typing import List

# First attempt, time limited exceeded.
# Second attempt time limited exceeded, switching to bouquets3.py

# DESPERATE ATTEMPT JUST TO REVERSE THE DAY ORDER, NOT GOOD IDEA

class Solution:
    def minDays(self, bloomDay: List[int], m: int, k: int) -> int:
        """ """
        unique_bloom_days = list(set(bloomDay))
        unique_bloom_days.sort(reverse=True)
        # print(unique_bloom_days)

        def possible_boq(bool_list, k):
            """Return the number of bouquets, OF SIZE k, can be made from bool_list"""
            bool_string = ''
            for flower in bool_list:
                bool_string += str(flower)
            # print(bool_string)
            ones = bool_string.split('0')
            # print(ones)

            temp = [x for x in ones if len(x) >= k]
            good_boqs = 0
            for subset in temp:
                good_boqs += len(subset) // k
            # print(good_boqs)
            return good_boqs

        for j in range(len(unique_bloom_days)):
            is_bloomed = [1 if (i - unique_bloom_days[j]) <= 0 else 0 for i in bloomDay]
            if is_bloomed.count(1) < m * k:
                continue
            # print(is_bloomed)
            possible_this_day = possible_boq(is_bloomed, k)
            # print(possible_this_day)
            if possible_this_day < m:
                print(unique_bloom_days[j-1])
                return unique_bloom_days[j-1]
        else:
            # print("no solution, returning -1")
            return -1


a = Solution()
a.minDays([1,10,3,10,2], 3, 1)
# a.minDays([1,10,3,10,2], 3, 2)
# a.minDays([7,7,7,7,12,7,7], 2, 3)
# a.minDays([1000000000,1000000000], 1, 1)
# a.minDays([1,10,2,9,3,8,4,7,5,6], 4, 2)