from typing import List

# time limit exceeded
class Solution:
    def xorQueries(self, arr: List[int], queries: List[List[int]]) -> List[int]:
        """XOR is exclusive or, A OR B but not A AND B"""
        # XOR iS COMMUTATIVE
        def xoroperator(a,b):
            """a,b binary, SAME LENGTH NECCESARY"""
            astr = str(a)
            bstr = str(b)
            # a = 0001 
            # b = 0011 
            cstr = ''
            for i in range(len(astr)):
                if astr[i] == '0' and bstr[i] == '0':
                    cstr += '0'
                elif astr[i] == '1' and bstr[i] == '0':
                    cstr += '1'
                elif astr[i] == '0' and bstr[i] == '1':
                    cstr += '1'
                elif astr[i] == '1' and bstr[i] == '1':
                    cstr += '0'
            return(cstr)

        def equallength(alist):
            b = [len(obj) for obj in alist]
            tempmax = max(b)

            # print(tempmax)

            clist = []

            for obj in alist:
                while len(obj) < tempmax:
                    obj = '0' + obj
                clist.append(obj)
            return(clist)

        def tobinarylist(alist):
            """takes a list of ints, outputs a list of binary strings"""
            blist = []

            for obj in alist:
                blist.append(str("{0:b}".format(obj)))
            return(blist)

        def xoroflist(alist):
            if len(alist) == 0:
                return("Something broke")
            elif len(alist) == 1:
                return(alist)
            else:
                answer = ""
                for i in range(len(alist[0])):
                    mysum = 0
                    for j in range(len(alist)):
                        mysum += int(alist[j][i])
                    if mysum == len(alist[0]):
                        answer += '0'
                    elif mysum == 0:
                        answer += '0'
                    else:
                        answer += 1
            return(answer)
        
        def binaryToDecimal(n): 
            return int(n,2) 
        
        binaryarr = equallength(tobinarylist(arr))
        # print(binaryarr)

        answer1 = []
        for query in queries:
            targetquery = binaryarr[query[0]:query[1]+1]
            answer1.append(xoroflist(targetquery))
        print(answer1)

        ultimateanswer = []
        for obj in answer1:
            if type(obj) == str:
                ultimateanswer.append(binaryToDecimal(obj))
            elif type(obj) == list:
                ultimateanswer.append(binaryToDecimal(obj[0]))
        print(ultimateanswer)
        return(ultimateanswer)
        
a = Solution()
a.xorQueries([1,3,4,8],[[0,1],[1,2],[0,3],[3,3]])