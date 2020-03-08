class Solution:
    def generateTheString(self, n: int) -> str:
        
        if n % 2 == 0:
            ans = "x"*(n-1) + 'y'
        else:
            ans = "x"*n
        # print(ans)
        return(ans)



a = Solution()
a.generateTheString(4)
a.generateTheString(2)
a.generateTheString(7)

