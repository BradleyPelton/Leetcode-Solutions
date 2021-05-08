def haszeros(n):
    mystr = str(n)
    for char in mystr:
        if char == '0':
            return(True)
    return(False)
print(haszeros(324523452345))