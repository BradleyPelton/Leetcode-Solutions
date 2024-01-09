import collections
from typing import List
class contests2020q4.leetcode20201017.Solution:
    def maxSumDivThree(self, nums: List[int]) -> int:
        
        modDict = dict()
        
        for ele in nums:
            modDict[ele] = ele % 3
        
        print(modDict)

        zeroDict = {k:v for (k,v) in modDict.items() if v == 0}
        # print(zeroDict)
        oneDict = {k:v for (k,v) in modDict.items() if v == 1}
        twoDict = {k:v for (k,v) in modDict.items() if v == 2}

        # print(zeroDict)
        # print(oneDict)
        # print(twoDict)

        zeroOD = collections.OrderedDict(sorted(a.items()))
        oneOD = collections.OrderedDict(sorted(oneDict.items()))
        twoOD = collections.OrderedDict(sorted(twoDict.items()))

        print(zeroOD,oneOD,twoOD)


        answerList = []
        answerList.append(zeroDict.keys())

        aTwo = next(reversed(twoOD))
        aOne = next(reversed(oneOD))
        bOne = next(reversed(oneOD))
        cOne = next(reversed(oneOD))
        
        if aTwo + aOne > aOne + bOne + cOne:
            answerList.append(aTwo)
            answerList.append(aOne)
            aTwo = next(reversed(twoOD))
            aOne = next(reversed(oneOD))
        else:
            answerList.append(aOne)
            answerList.append(bOne)
            answerList.append(cOne)
            aOne = next(reversed(oneOD))
            aOne = next(reversed(oneOD))
            aOne = next(reversed(oneOD))           
        while 
        # while True:
        #     try:
        #         aTwo = max(zeroDict, key=int)
        #         aOne = next(reversed(oneOD))
        #         bOne = next(reversed(oneOD))
        #         cOne = next(reversed(oneOD))

        #         if aTwo + aOne > aOne + bOne + cOne:
        #             answerList.append(aTwo)
        #             answerList.append(aOne)
        #         else:
        #             answerList.append(aOne,)
        #     except KeyError,IndexError:
        #         break

        #FOR EVERY 2 I NEED A 1
        #FOR EVERY 1 I NEED TWO OTHER 1'S

        #THE PROBLEM:   
        # having to choose whether picking a 2 and a 1 instead of just three 1's

        # #RETURN ALL 3 HIGHEST KEYS SUCH THAT modDict[key] == 0
        # a = next(reversed(zeroOD))
        # b = next(reversed(zeroOD))
        # c = next(reversed(zeroOD))

        # #RETURN ALL 3 HIGHEST KEYS SUCH THAT modDict[key] == 1
        # d = next(reversed(oneOD))
        # e = next(reversed(oneOD))
        # f = next(reversed(oneOD))
        # #RETURN THE HIGHEST KEY SUCH THAT modDict[key] == 2, KEY  == 1, and KEY == 0
        # h = next(reversed(twoOD))