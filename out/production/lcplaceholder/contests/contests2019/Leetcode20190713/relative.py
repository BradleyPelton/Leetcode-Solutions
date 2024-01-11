# arr2 is distinct
# arr2 is contained in arr1
from collections import Counter

#clump all like values together

class contests2020q4.leetcode20201017.Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        dict1 = dict(Counter(arr1))
        temp = []
        for char in arr1:
            if char not in arr2:
                temp.append(char)
        temp.sort()

        temp2 = []
        for char in arr2:
            for i in range(dict1[char]):
                temp2.append(char)
        return(temp2+temp)





Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]
        [2,2,2,1,4,3,3,9,6,7,19]

my output [2, 2, 2, 1, 4, 3, 3, 9, 6]