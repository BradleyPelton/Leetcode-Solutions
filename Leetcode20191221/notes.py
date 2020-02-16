

def isConsecutive(mylist):
    for i in range(1,len(mylist)):
        if mylist[i] != mylist[i-1]+1:
            return(False)
        return(True)

print(isConsecutive([1,2,3]))
print(isConsecutive([1,3,3]))
print(isConsecutive([1,1,1]))
print(isConsecutive([1,2,3]))
print(isConsecutive([1,2,10]))




