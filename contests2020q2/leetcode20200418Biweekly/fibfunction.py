def create_fib_list(n):
    """ return a lsit of fib numbers less than n"""
    fib_list = [1,1]

    if n == 1:
        return []
    elif n == 2:
        return fib_list

    while fib_list[-1] < n:
        fib_list.append(fib_list[-2]+fib_list[-1])

    fib_list.pop()
    return(fib_list)

print(len(create_fib_list(1000000000)))
# print(create_fib_list(2))
# print(create_fib_list(3))
# print(create_fib_list(5))
