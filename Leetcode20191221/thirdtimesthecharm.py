from typing import List
from collections import Counter

class Solution:
    def isPossibleDivide(self, nums: List[int], k: int) -> bool:
        nums.sort()


        def isConsecutive(mylist):
            for i in range(1,len(mylist)):
                if mylist[i] != mylist[i-1]+1:
                    return(False)
                return(True)
    
        def create(mylist):
            mylist.sort()
            """create the list of lists"""
            mydict = dict(sorted(Counter(mylist).items()))
            return(mydict)

        second  = create(nums)
        # for key in second.keys():
        #     while key >0:
        #         pass
        keyslist = list(second.keys())
        # print(second)
        # print(keyslist)
        for i in range(len(keyslist)-k):
            try:
                while second[keyslist[i]] > 0:
                    try:
                        for i in range(k):
                            second[keyslist[i+k]] -= 1
                    except KeyError:
                        print("KEY ERROR")
                        return(False)
            except IndexError:
                continue
        print(second)
        for count in list(second.values()):
            if count != 0:
                return(False)
        print("SHIT IS TRUE")
        return(True)
        
    
    
a = Solution()
# print(a.isPossibleDivide([3,2,1,2,3,4,3,4,5,9,10,11],3))
# a.isPossibleDivide([1,2,3,4],3)

print(a.isPossibleDivide([1,2,3,3,4,4,5,6],4))