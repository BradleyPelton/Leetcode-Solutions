from collections import Counter
from typing import List
class contests2020q4.leetcode20201017.Solution:
    def minSetSize(self, arr: List[int]) -> int:
        copy = arr[:]


        thecount = 0
        while len(copy) > (len(arr) * .5):
            thecount += 1
            ct = Counter(copy)
            temp = ct.most_common(1)[0][0]
            print(temp)
            copy = list(filter(lambda a: a != temp, copy))
            print(copy)

        print("thecount is equal to {}".format(thecount))
        return(thecount)


a = contests2020q4.leetcode20201017.Solution()
a.minSetSize([3,3,3,3,5,5,5,2,2,7])
a.minSetSize([7,7,7,7,7,7])
a.minSetSize([1,9])
a.minSetSize([1000,1000,3,7])
a.minSetSize([1,2,3,4,5,6,7,8,9,10])