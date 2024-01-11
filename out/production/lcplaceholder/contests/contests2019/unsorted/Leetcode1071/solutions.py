

def divs(strA,strB):
    """ returns true if strA divides strB"""
    for i in range(0,1001):
        if strB == strA*i:
            return(True)
    return(False)

def subs(input_string):
  length = len(input_string)
  ourlist = []
  for i in range(length-1):
      ourlist.append(input_string[:i])
      


largest = ''

str1 = "ABABAB"
str2 = "ABAB"
subs1 = subs(str1)

for i in range(0, len(subs1)-1):
    ith = subs1[i]
    if divs(ith,str2) and divs(ith,str1) and len(ith) > len(largest):
        largest = ith

if len(largest) < 1:
    print("")
else:
    print(largest)

    

    

