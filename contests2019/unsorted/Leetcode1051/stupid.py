
heights = [1,1,4,2,1,3]


newList = heights
newList.sort()
count = 0
for i in range(len(heights)):
    if newList[i] == heights[i]:
        print(newList[i],heights[i])
        count+=1
        print(count)
print((len(heights)-count))