def bitwise_list(sublist: list):
    """ return the value of running bitwise or over entire list"""
    copy = sublist[:]

    if len(sublist) == 0:
        return "WAS GIVEN AN EMPTY LIST"
    elif len(sublist) == 1:
        return sublist[0]

    val = sublist[0] ^ sublist[1]
    for ele in sublist[2:]:
        val ^= ele
    return val


bitwise_list([2,3,1,6,7])