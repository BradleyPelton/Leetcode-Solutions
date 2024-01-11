from typing import List
import math
class contests2020q4.leetcode20201017.Solution:
    def sumFourDivisors(self, nums: List[int]) -> int:
        def printDivisors(n) : 
            i = 1
            # divi = [1,n]
            divi = []
            while i <= math.sqrt(n): 
                if (n % i == 0) : 
                    # If divisors are equal, print only one 
                    if (n / i == i) : 
                        divi.append(i)
                    else : 
                        divi.append(i)
                        divi.append(n/i) 
                i = i + 1
            return(divi)

        res = 0
        for num in nums:
            # print(printDivisors(num))
            if len(printDivisors(num)) == 4:
                res += sum(printDivisors(num))
        print(int(res))
        return(int(res))
        


a = contests2020q4.leetcode20201017.Solution()
a.sumFourDivisors([21,4,7])
            