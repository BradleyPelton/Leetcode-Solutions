
def allgreater(alist, value):
    for i in range(len(alist)):
        if alist[i] < value:
            alist[i] = value
    return(alist)

print(allgreater([1,2,3,4,5,6,7],3))