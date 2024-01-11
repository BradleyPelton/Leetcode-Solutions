

class contests2020q4.leetcode20201017.Solution:
    def minFlips(self, a: int, b: int, c: int) -> int:

        def inttobin(n):
            """converts int to bin"""
            return(("{0:b}".format(n)))
        def equallength(alist):
            b = [len(obj) for obj in alist]
            tempmax = max(b)
            clist = []
            for obj in alist:
                while len(obj) < tempmax:
                    obj = '0' + obj
                clist.append(obj)
            return(clist)

    






    
        def bitwiseor(bin1,bin2):
            str1 = str(bin1)
            str2 = str(bin2)

            
        Does a "bitwise or". Each bit of the output is 0 if the corresponding bit of x AND of y is 0, otherwise it's 1.