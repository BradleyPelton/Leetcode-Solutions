
# Solved after 11 minutes. First two attempts were rejected
# I didnt take into account s = 'c' , a single character
# and s = 'cc' when the entire list is a single character
class contests2020q4.leetcode20201017.Solution:
    def maxPower(self, s: str) -> int:
        
        if len(s) == 1:
            return 1

        subs = []
        temp = ''
        for char in s:
            if temp == '':
                temp += char
            elif temp[-1] == char:
                temp += char
            else:
                subs.append(temp)  # append the last sub
                temp = str(char)
        subs.append(temp)

        print(subs)

        powers = [len(sub) for sub in subs]
        print(max(powers))
        return max(powers)

a = contests2020q4.leetcode20201017.Solution()
# a.maxPower('leetcode')
# a.maxPower('abbcccddddeeeeedcba')
# a.maxPower('triplepillooooow')
# a.maxPower('hooraaaaaaaaaaay')
# a.maxPower('tourist')
a.maxPower('j')
# a.maxPower('cc')