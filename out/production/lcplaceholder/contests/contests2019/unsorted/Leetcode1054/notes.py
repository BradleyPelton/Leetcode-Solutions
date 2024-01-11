
import math


#newlist  = [oldlist[0],[-1],[1],[-2],...]

barcodes = [2,2,1,3]
#after sort 1,2,2,3



newlist = []
barcodes.sort()
mylen = len(barcodes)

newlist.append(barcodes[0])
newlist.append(barcodes[-1])

for i in range (1,int(math.floor(mylen/2))):
    newlist.append(barcodes[i])
    newlist.append(barcodes[-i-1])

newlist.append(barcodes[int((mylen-1)/2)])
print(newlist)

