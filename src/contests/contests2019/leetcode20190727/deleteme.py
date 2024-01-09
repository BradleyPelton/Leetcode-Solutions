def is_leap(year):
    leap = False
    
    if year%400 == 0:
        leap = True
        return(leap)
    elif year%100 == 0:
        pass
    elif year%4 == 0:
        leap = True

    
    return leap

print(is_leap(2000))