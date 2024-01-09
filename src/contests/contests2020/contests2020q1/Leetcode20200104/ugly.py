for i in range(len(s)):
    try:
        if s[i+2] == '#':
            pretty.append(s[i]+s[i+1]+s[i+2])
        elif s[i+1] == '#':
            pass
        elif s[i] == '#':
            pass
        else:
            pretty.append(s[i])
    except IndexError:
        pass