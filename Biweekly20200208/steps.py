

class Solution:
    def numberOfSteps (self, num: int) -> int:
        count = 0
        while num > 0:
            if num  % 2 == 0:
                num = num/2
                count += 1
            elif num % 2 == 1:
                num -= 1
                count += 1
        print(count)
        return(count)




a = Solution()
a.numberOfSteps(14)
a.numberOfSteps(8)
