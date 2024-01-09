class contests2020q4.leetcode20201017.Solution:
    def generateTheString(self, n: int) -> str:
        
        if n % 2 == 0:
            ans = "x"*(n-1) + 'y'
        else:
            ans = "x"*n
        # print(ans)
        return(ans)



a = contests2020q4.leetcode20201017.Solution()
a.generateTheString(4)
a.generateTheString(2)
a.generateTheString(7)

