
# Accepted after first submission. After 5 minutes. 
# I hate XOR problems... gotta study up on these
class Solution:
    def xorOperation(self, n: int, start: int) -> int:
        

        ors = [start + 2*i for i in range(n)]

        res = ors[0]
        # print(f"res before {res}")

        # print(n)

        for j in range(1,len(ors)):
            res ^= ors[j]

        # print(f"res after {res}")
        return res


a = Solution()
# a.xorOperation(5, 0)
# a.xorOperation(4, 3)
# a.xorOperation(1, 7)
a.xorOperation(10, 5)