from typing import List

# Accepted after 6 minutes, first try. Lengthy word problem sigh

class Solution:
    def finalPrices(self, prices: List[int]) -> List[int]:
        """ """

        ans = []
        for i in range(len(prices)):
            for j in range(len(prices)):
                if prices[j] <= prices[i] and j > i:
                    ans.append(prices[i] - prices[j])
                    break
            else:
                ans.append(prices[i])
        
        print(ans)
        return ans

a = Solution()
# a.finalPrices([8,4,6,2,3])
a.finalPrices([10,1,1,6])
