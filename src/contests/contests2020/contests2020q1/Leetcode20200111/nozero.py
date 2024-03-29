from typing import List

class contests2020q4.leetcode20201017.Solution:
    def getNoZeroIntegers(self, n: int) -> List[int]:
        
        def haszeros(n):
            mystr = str(n)
            for char in mystr:
                if char == '0':
                    return(True)
            return(False)

        a = n//2
        b = n - a
        # print(a,b)

        for _ in range(n):
            if haszeros(a) or haszeros(b):
                print(a,b)
                a += 1
                b -= 1
            else:
                break
        print(a,b)
        return(a,b)


a = contests2020q4.leetcode20201017.Solution()
a.getNoZeroIntegers(1010)