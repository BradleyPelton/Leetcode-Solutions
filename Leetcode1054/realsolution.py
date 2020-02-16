import random
import math



class Solution(object):
    def rearrangeBarcodes(self, barcodes):
        """
        :type barcodes: List[int]
        :rtype: List[int]
        """
        mylen = len(barcodes)
        if mylen == 1:
            return(barcodes)
        newlist = []
        barcodes.sort()
        elif mylen % 2 == 0:         #even
            newlist = []
            barcodes.sort()
            newlist.append(barcodes[0])
            newlist.append(barcodes[-1])
            for i in range (1,int(mylen/2)):
                newlist.append(barcodes[i])
                newlist.append(barcodes[-i-1])

            return(newlist)
        else:                               #odd
            newlist = []
            barcodes.sort()
            newlist.append(barcodes[0])
            newlist.append(barcodes[-1])
            for i in range (1,int(math.floor(len(barcodes)/2))):
                newlist.append(barcodes[i])
                newlist.append(barcodes[-i-1])
            newlist.append(barcodes[int((mylen-1)/2)])
            return(newlist)
