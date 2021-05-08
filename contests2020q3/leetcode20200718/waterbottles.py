
## Accepted after 7 minutes, first attempt

## I should have just used the math solution instead of trying to build the algorithm to count
## but this is probably the intended solution.

class contests2020q4.leetcode20201017.Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        

        final_count = 0

        num_of_empty = 0

        for _ in range(1000):

            if numBottles == 0 and num_of_empty < numExchange:
                break
            elif numBottles > 0:
                final_count += numBottles
                num_of_empty += numBottles
                numBottles = 0

            # exchange
            if num_of_empty >= numExchange:
                exch_count = num_of_empty // numExchange
                num_of_empty -= exch_count * numExchange
                numBottles += exch_count
            
            

            # print(f"after round{_}, final_count = {final_count}, num_of_empty = {num_of_empty}")
        # print(final_count)
        return final_count

a = contests2020q4.leetcode20201017.Solution()
a.numWaterBottles(numBottles = 9, numExchange = 3)
a.numWaterBottles(numBottles = 15, numExchange = 4)
a.numWaterBottles(numBottles = 5, numExchange = 5)
a.numWaterBottles(numBottles = 2, numExchange = 3)