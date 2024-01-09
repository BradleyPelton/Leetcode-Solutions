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


xoroperator('0001','0011')
xoroperator('0011','0100')