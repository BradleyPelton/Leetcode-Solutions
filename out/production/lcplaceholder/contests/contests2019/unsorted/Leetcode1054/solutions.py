import random

#leetcode contest 1054


class contests2020q4.leetcode20201017.Solution(object):
    def rearrangeBarcodes(self, barcodes):
        """
        :type barcodes: List[int]
        :rtype: List[int]
        """
        def meetsCondition(ourlist):
            for i in range(len(ourlist)-1):
                if ourlist[i] == ourlist[i+1]:
                    return(False)
            return(True)

        for i in range(1000000):
            if meetsCondition(barcodes) == False:
                random.shuffle(barcodes)
            else:
                return(barcodes)
