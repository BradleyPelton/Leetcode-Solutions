def xoroperator(a,b):
    """a,b binary, SAME LENGTH NECCESARY"""
    astr = str(a)
    bstr = str(b)
    # a = 0001 
    # b = 0011 
    cstr = ''
    for i in range(len(astr)):
        if astr[i] == '0' and bstr[i] == '0':
            cstr += '0'
        elif astr[i] == '1' and bstr[i] == '0':
            cstr += '1'
        elif astr[i] == '0' and bstr[i] == '1':
            cstr += '1'
        elif astr[i] == '1' and bstr[i] == '1':
            cstr += '0'
    return(cstr)


def xoroflist(alist):
    if len(alist) == 0:
        return("Something broke")
    elif len(alist) == 1:
        return(alist)
    else:
        answer = ""
        for i in range(len(alist[0])):
            mysum = 0
            for j in range(len(alist)):
                mysum += int(alist[j][i])
            if mysum == len(alist[0]):
                answer += '0'
            elif mysum == 0:
                answer += '0'
            else:
                answer += 1
    return(answer)