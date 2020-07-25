# Accepted first attempt


class Solution:
    def numJewelsInStones(self, J: str, S: str) -> int:
        """ """

        jewel_count = 0

        for stone in S:
            if stone in J:
                jewel_count += 1

        print(jewel_count)
        return jewel_count

a = Solution()
a.numJewelsInStones(J = "aA", S = "aAAbbbb")
a.numJewelsInStones(J = "z", S = "ZZ")