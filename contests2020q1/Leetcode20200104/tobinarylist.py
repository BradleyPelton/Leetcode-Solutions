def tobinarylist(alist):
    """takes a list of ints, outputs a list of binary strings"""
    blist = []

    for obj in alist:
        blist.append(str("{0:b}".format(obj)))
    return(blist)


tobinarylist([1,3,4,8])

    