import math
from typing import List

class contests2020q4.leetcode20201017.Solution:
    def closestDivisors(self, num: int) -> List[int]:
        
        # print(math.sqrt(num))
        exact_sqrt = math.sqrt(num)
        lower = math.floor(exact_sqrt)
        upper = lower + 1
        # print(lower,upper)

        step = 'a'
        closest = []    
        for _ in range(1000):
            print(count)
            count += 1
            if upper*lower == num+1 or upper*lower == num+2:
                print("found a solution",upper,lower)
                break
            else:
                if step == 'a':
                    lower -= 1
                    step = 'b'
                elif step == 'b':
                    upper += 1
                    step = 'a'
        


a = contests2020q4.leetcode20201017.Solution()
a.closestDivisors(123)