from typing import List

# First attempt, time limited exceeded. Switching to bouequets2.py
class Solution:
    def minDays(self, bloomDay: List[int], m: int, k: int) -> int:
        """ """
        unique_bloom_days = list(set(bloomDay))
        unique_bloom_days.sort()
        # print(unique_bloom_days)

        def possible_boq(bool_list , k):
            """Return the number of bouquets, OF SIZE k, can be made from bool_list"""
            bool_string = ''
            for flower in bool_list:
                bool_string += str(flower)
            # print(bool_string)
            ones = bool_string.split('0')
            # print(ones)

            good_boqs = 0
            for subset in ones:
                good_boqs += len(subset) // k
            # print(good_boqs)
            return good_boqs

        print(f"m is {m}")
        for day in unique_bloom_days:
            temp = [num - day for num in bloomDay]
            is_bloomed = [1 if i <= 0 else 0 for i in temp]
            # print(is_bloomed)
            possible_this_day = possible_boq(is_bloomed, k)
            # print(possible_this_day)
            if possible_this_day >= m:
                print(f"FIRST DAY IS {day}")
                return day
        else:
            print("no sulution, returning -1")
            return -1
        


a = Solution()
# a.minDays([1,10,3,10,2], 3, 1)
# a.minDays([1,10,3,10,2], 3, 2)
# a.minDays([7,7,7,7,12,7,7], 2, 3)
# a.minDays([1000000000,1000000000], 1, 1)
a.minDays([1,10,2,9,3,8,4,7,5,6], 4, 2)