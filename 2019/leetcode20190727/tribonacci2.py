class Solution:
    def tribonacci(self, n):
        tribList = [0,1,1]
        while len(tribList) < n+1:
            tribList.append(tribList[-1]+tribList[-2]+tribList[-3])
        return(tribList[n])
        
        # def asequence(a,b,c):

MySolution = Solution()
print(MySolution.tribonacci(25))
        