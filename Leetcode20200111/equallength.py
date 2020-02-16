def equallength(alist):
    b = [len(obj) for obj in alist]
    tempmax = max(b)

    # print(tempmax)

    clist = []

    for obj in alist:
        while len(obj) < tempmax:
            obj = '0' + obj
        clist.append(obj)
    return(clist)