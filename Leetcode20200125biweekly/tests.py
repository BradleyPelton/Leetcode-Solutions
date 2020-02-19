from collections import deque
def isAllA(mystring):
    mydeque = deque(mystring)
    print(mydeque)
    while 'a' in mydeque:
        mydeque.remove('a')
    if len(mydeque) ==0:
        return(True)
    else:
        return(False)

print(isAllA('abccba'))