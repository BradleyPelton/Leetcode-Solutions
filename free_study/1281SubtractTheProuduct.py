# Accepted after first attempt


class contests2020q4.leetcode20201017.Solution:
    def subtractProductAndSum(self, n: int) -> int:
        

        n_str = str(n)

        total_product = 1
        total_sum = 0

        for digit in n_str:
            total_sum += int(digit)
            total_product *= int(digit)

        # print(total_sum)
        # print(total_product)

        return total_product - total_sum


a = contests2020q4.leetcode20201017.Solution()
a.subtractProductAndSum(4421)