class Solution:
    def isArmstrongNumber(self,n):
        myList = [int(i) for i in str(n)]
        print(myList)
        mysum = 0
        for num in myList:
            mysum += num**3
        if mysum == n:
            return(True)
        return(False)



aSolution = Solution()
print(aSolution.isArmstrongNumber(153))
print(aSolution.isArmstrongNumber(123))