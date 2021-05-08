
## accepted first try after 7 minutes. Sloppy edge case handling took too much time

class contests2020q4.leetcode20201017.Solution:
    def thousandSeparator(self, n: int) -> str:
        
        rev_string = str(n)[::-1]

        ans = rev_string[0]
        for i in range(1,len(rev_string)):
            if i % 3 == 0:
                ans += "."
                ans += (rev_string[i])
            else:
                ans += (rev_string[i])
        
        ans = ans[::-1]
        print(ans)
        return ans


a = contests2020q4.leetcode20201017.Solution()
a.thousandSeparator(n = 123456789)
a.thousandSeparator(n = 1234)
a.thousandSeparator(n = 987)
a.thousandSeparator( n = 0)