class Solution:
    def tribonacci(self, n):
        if n == 0:
            return(0)
        elif n==1:
            return(1)
        elif n==2:
            return(1)
        else:
            return(self.tribonacci(n-1)+self.tribonacci(n-2)+self.tribonacci(n-3))
        
        # def asequence(a,b,c):

MySolution = Solution()
print(MySolution.tribonacci(27))
        