def isintersect(interval1,interval2):
    # [[a,b],[c,d]]
    if interval2[0] < interval1[1]:
        return(True)
    return(False)



print(isintersect([1,3],[2,4]))
print(isintersect([1,10],[10,15]))
print(isintersect([0,30],[10,20]))
print(isintersect([1,3],[2,4]))
print(isintersect([1,3],[2,4]))
print(isintersect([1,3],[2,4]))