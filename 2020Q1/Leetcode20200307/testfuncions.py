def all_blue(moment_list):
    if moment_list == [1] + [0]*(len(moment_list)-1):
        return(True)

    for i in range(1,len(moment_list)):
        if moment_list[i] == 1: # if a bulb is turned on
            if moment_list[i-1] == 0: # presence of a gap
                return(False)
    return(True)

def all_blue_2(moment_list):
    if moment_list == [1] + [0]*(len(moment_list)-1):
        return(True)
    if moment_list == [1]*(len(moment_list)):
        return(True)
    # print(moment_list)
    # print([1]*(len(moment_list)-1))

    
    first_zero = moment_list.index(0)
    copy_list = moment_list[:]
    copy_list.reverse()
    last_one = len(copy_list) - copy_list.index(1) - 1
    # print(first_zero)
    # print(last_one)

    # if the index of the first zero is less than the index of the last 1
    # there exists a gap, return False
    if first_zero < last_one:
        return(False)
    return(True)

def all_blue_3(moment_list):

    moment_sum = sum(moment_list)
    

# print(all_blue_2([1,0,0,0,0]))
# print(all_blue_2([1,0,1,0,0]))
# print(all_blue_2([1,1,1,0,0]))
# print(all_blue_2([1,0,1,0,1]))
# print(all_blue_2([1,1,1,1,1]))
