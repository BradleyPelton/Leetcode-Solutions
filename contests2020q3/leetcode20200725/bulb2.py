# Accepted after second solution. Nice and elegant refined answer


class contests2020q4.leetcode20201017.Solution:
    def minFlips(self, target: str) -> int:
        # ones_list = target.split("0")
        # print(ones_list)
        # print(len(ones_list))

        if target == "0"*len(target):
            print(0)
            return 0

        ans = 0
        current_digit = '0'

        
        for i in range(len(target)):
            # print(target[i])
            if target[i] != current_digit:
                print(f"flipping at {i}")
                ans += 1
                current_digit = target[i]
        print(ans)
        return ans

a = contests2020q4.leetcode20201017.Solution()
a.minFlips("10111")  # Expected 3
# a.minFlips("101")  # Expected 3
# a.minFlips("00000")  # Expected 0 
# a.minFlips("001011101")  # Expected 5