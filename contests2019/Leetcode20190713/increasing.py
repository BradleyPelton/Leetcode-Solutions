"""find out if this array can be divided into one or more DISJOINT increasing subsequenc of length at least k"""

from collections import Counter


class contests2020q4.leetcode20201017.Solution:
    def canDivideIntoSubsequences(self, nums: List[int], K: int) -> bool:
        dict1 = dict(Counter(nums)) #[1,2,2,3,3,4,4] -> {1: 1, 2: 2, 3: 2, 4: 2}
        # print(dict1)
        modeCount = 0
        for key in dict1:
            if dict1[key] > modeCount:
                modeCount = dict1[key]  
        #print(modeCount)
        ### since subsets have to be strictly increasing, the numberOfSubsets must be >= modeCount
        ### if a solution exists, it also exists when numberOfSubsets == modeCount (proved ish)



        answerDict = {}     ##answerDict is just an enumerated dict of List {"0":[1,2,3] , "1": [2,3,4]}
        realAnswerDict = []
        for i in range(0,modeCount):  
            answerDict[i] = []          #initializing the subsets in answerDict




        for key in dict1:               #the actual numbers in nums
            temp = int(dict1[key])
            while temp > 0:            #Count
                # answerDict[i].append(key)            ### adding the numbers to the i-th subset
                for i in range(0,modeCount):
                    if len(answerDict[i]) == K:
                        # realAnswerDict[i] = answerDict[i]
                        # answerDict[i].pop(i)
                        pass
                    else:
                        answerDict[i].append(int(key))
                        temp -= 1
                    
        print(answerDict)
    

        for key in realAnswerDict:
            if len(realAnswerDict[key])< K:
                return(False)
        return(True)
