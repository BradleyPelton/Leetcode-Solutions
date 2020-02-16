

stones = [2,7,4,1,8,1]


while len(stones) > 1:
    stones.sort()
    newList = stones
    if newList[-1] == newList[-2]:
        newList.pop()
        newList.pop()              ##same size
    elif newList[-1] > newList[-2]:
        newStone = newList[-1] - newList[-2]
        newList.pop()
        newList.pop()
        newList.append(newStone)
    else:
        newStone = newList[-2] - newList[-1]
        newList.pop()
        newList.pop()
        newList.append(newStone)
    newList.sort()
    stones = newList
if len(stones) == 1:
    return(stones[0])
else:
    return(0)

