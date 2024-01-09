
# Solved in 12 minutes. First attempt forgot to comment out print statements and received
# Output Limit Exceeded failure. Not a hard problem, just tedious
class contests2020q4.leetcode20201017.Solution:
    def reformat(self, s: str) -> str:
        """ """
        letters = [let for let in s if let.isalpha()]
        numbers = [num for num in s if num.isnumeric()]
        # print(letters, numbers)

        if abs(len(numbers)-len(letters)) > 1:
            return ""
        res = ''
        if len(letters) > len(numbers):
            while len(letters) > 1:
                # print(letters)
                let_pop = letters.pop()
                res += let_pop
                num_pop = numbers.pop()
                res += num_pop
            # last element
            res += letters[0]
        elif len(numbers) > len(letters):
            while len(numbers) > 1:
                # print(letters)
                num_pop = numbers.pop()
                res += num_pop
                let_pop = letters.pop()
                res += let_pop
            # last element
            res += numbers[0]
        else:
            # same lengths
            while len(numbers) > 1:
                # print(letters)
                num_pop = numbers.pop()
                res += num_pop
                let_pop = letters.pop()
                res += let_pop
            res += numbers[0] + letters[0]
        print(res)
        return(res)


a = contests2020q4.leetcode20201017.Solution()
a.reformat('a0b1c2')
# a.reformat('covid2019')
# a.reformat('leetcode')
# a.reformat('1229857369')

