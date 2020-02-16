from itertools import permutations


myLength = int(input())
inputStr = input()
subsetLength = int(input())

myStr = inputStr.replace(" ",'')
#print(myStr)

newList = list(permutations(myStr,subsetLength))
#print(newList)

count = 0
for obj in newList:
    for i in range(subsetLength):
        if obj[i] == 'a':
            count += 1
            break
            

print(count/len(newList))



