from typing import List
import math
class contests2020q4.leetcode20201017.Solution:
    def findBestValue(self, arr: List[int], target: int) -> int:
        """minimize the | sum(arr) - target | by manipulating arr freely"""

        def allgreater(alist, value):
            blist = alist[:]
            for i in range(len(alist)):
                if blist[i] > value:
                    blist[i] = value
            return(blist)


        answers = dict()

        # THIS ONLY WORKS IF THE VALUE HAS TO BE IN ARR
        for i in range(len(arr)):
            # print(allgreater(arr,arr[i]))
            answers[arr[i]] = sum(allgreater(arr,arr[i]))
        
        perfect = target//len(arr)
        # print(perfect)
        answers[perfect-1] = sum(allgreater(arr,perfect-1))
        answers[perfect] = sum(allgreater(arr,perfect))
        answers[perfect+1] = sum(allgreater(arr,perfect+1))


        for key, value in answers.items():
            answers[key] = answers[key] - target
            answers[key] = abs(answers[key])
        print(answers)
    
        print(min(answers, key=answers.get))
        return(min(answers, key=answers.get))
        # print(answers)


a = contests2020q4.leetcode20201017.Solution()
a.findBestValue([4,9,3],10)
# a.findBestValue([2,3,5],10)
# a.findBestValue([60864,25176,27249,21296,20204],56803)
