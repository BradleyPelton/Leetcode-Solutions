from typing import List
from collections import deque
class contests2020q4.leetcode20201017.Solution:
    def printVertically(self, s: str) -> List[str]:

        res = s.split(" ")

        def equalLength(mylist):
            """mylist is a list of strings"""

            lengths = [len(obj) for obj in mylist]
            greatest = max(lengths)

            print("greatest length is",greatest)

            copy = []
            for obj in mylist:
                while len(obj) < greatest:
                    obj += ' '
                    # print(obj, len(obj))
                copy.append(obj)
            return(copy)

        # print(equalLength(res))

        resequal = equalLength(res)
        strlengths = len(resequal[0])
        # print(strlengths)
        #convert every str
        resdequeue = [deque(obj) for obj in resequal]
        print(resdequeue)


        
        answer = []

        for _ in range(strlengths):
            temp = ''
            for deq in resdequeue:
                temp += str(deq.popleft())
            print(temp)
            answer.append(temp)

        answer2 = [obj.rstrip() for obj in equalLength(answer)]
        return(answer2)










a = contests2020q4.leetcode20201017.Solution()
a.printVertically("TO BE OR NOT TO BE")