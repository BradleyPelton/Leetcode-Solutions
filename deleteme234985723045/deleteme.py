import re

def norepeats(astring):
    astring = astring.replace("-","")
    try:
        for i in range(len(astring)):
            if (astring[i] == astring[i+1] and astring[i] == astring[i+2]
                and astring[i] == astring[i+3]):
                return(False)
    except IndexError:
        pass
    return(True)

def myreg(astring):
    reg = re.search("[456][0-9]{3}[-]?[0-9]{4}[-]?[0-9]{4}[-]?[0-9]{4}",astring)
    return(bool(reg))

def totalFunction(astring):
    if myreg(myNum) and (len(myNum) ==16 or len(myNum) ==19) and norepeats(myNum):
        print("Valid")
    else:
        print("Invalid")



num = int(input())

for _ in range(num):
    myNum = input()
    totalFunction(myNum)

    
