from typing import List



# Accepted first try, 4 minutes.
class contests2020q4.leetcode20201017.Solution:
    def average(self, salary: List[int]) -> float:
        max_sal = max(salary)
        min_sal = min(salary)

        correct_salaries = [sal for sal in salary if sal != max_sal and sal != min_sal]

        # print(correct_salaries)

        return sum(correct_salaries)/len(correct_salaries)

a = contests2020q4.leetcode20201017.Solution()
# a.average([4000,3000,1000,2000])
# a.average([1000,2000,3000])
a.average([8000,9000,2000,3000,6000,1000])