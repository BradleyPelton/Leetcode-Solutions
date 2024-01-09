from collections import Counter

class contests2020q4.leetcode20201017.Solution:
    def largestUniqueNumber(self, A):
        myCounter = dict(Counter(A))
        print(myCounter)
        highest = -1
        for key,value in myCounter.items():
            if key > highest and value == 1:
                highest = key
        if highest == -1:
            print(-1)
            
        print(highest)
            

mysolution = contests2020q4.leetcode20201017.Solution()
mysolution.largestUniqueNumber([5,7,3,9,4,9,8,3,1])
mysolution.largestUniqueNumber([9,9,8,8])