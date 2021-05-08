def findFirstZero(a):
    """returns the index of the first zero at the end of a string"""
    for i in range(len(a)-1,-1,-1):
        if a[i] == '1':
            continue
        elif a[i] == '0':
            return(i)


print(findFirstZero("00"))