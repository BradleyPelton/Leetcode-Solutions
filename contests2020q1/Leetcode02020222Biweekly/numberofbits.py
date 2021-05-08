from typing import List
from collections import defaultdict

class contests2020q4.leetcode20201017.Solution:
    def sortByBits(self, arr: List[int]) -> List[int]:

        def number_of_ones(num):
            bin_num = bin(num)[2:]

            count = bin_num.count('1')
            return(count)

        arrDict = defaultdict(int)
        for key in arr:
            arrDict[key] = number_of_ones(key)

        print('/n')
        # print(arrDict)
        sorted_dict = {k: v for k, v in sorted(arrDict.items(), 
            key=lambda item: item[1])}
        print(sorted_dict)

        ans = []
        mycount = 0
        for _ in range(1000):
            temp = []
            for key in sorted_dict.keys():
                if sorted_dict[key] == mycount:
                    temp.append(key)
            temp.sort()
            if temp:
                ans.extend(temp)
            mycount+= 1
        print(ans)
        return(ans)



a = contests2020q4.leetcode20201017.Solution()
# a.sortByBits([0,1,2,3,4,5,6,7,8])
# a.sortByBits([1024,512,256,128,64,32,16,8,4,2,1])
a.sortByBits([10000,10000])