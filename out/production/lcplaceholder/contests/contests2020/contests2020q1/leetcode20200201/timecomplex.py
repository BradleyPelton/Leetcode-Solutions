from collections import Counter
from typing import List
class contests2020q4.leetcode20201017.Solution:
    def minSetSize(self, arr: List[int]) -> int:
        copy = arr[:]
        copy.sort()

        ct = Counter(arr)
        most_com = ct.most_common()

        thecount = 0
        while len(copy) > (len(arr) * .5):
            temp = most_com[thecount][0]
            freq = most_com[thecount][1]
            first_occurence = copy.index(temp)
            copy = copy[:first_occurence] + copy[first_occurence+freq:]
            thecount += 1

        return(thecount)

a = contests2020q4.leetcode20201017.Solution()
a.minSetSize([3,3,3,3,5,5,5,2,2,7])
a.minSetSize([7,7,7,7,7,7])
a.minSetSize([1,9])
a.minSetSize([1000,1000,3,7])
a.minSetSize([1,2,3,4,5,6,7,8,9,10])