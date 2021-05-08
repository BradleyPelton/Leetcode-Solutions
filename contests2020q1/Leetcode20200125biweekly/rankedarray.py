from typing import List
class contests2020q4.leetcode20201017.Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        
        copy = arr[:]
        copy = list(set(copy))
        copy.sort()

        ans = [copy.index(i)+1 for i in arr]
        print(ans)
        return(ans)



a = contests2020q4.leetcode20201017.Solution()
a.arrayRankTransform([37,12,28,9,100,56,80,5,12])

