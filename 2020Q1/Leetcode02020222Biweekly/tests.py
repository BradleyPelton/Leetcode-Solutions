
def number_of_ones(num):
    bin_num = bin(num)[2:]

    count = bin_num.count('1')
    return(count)



# number_of_ones(3)
# number_of_ones(5)
# number_of_ones(6)

# number_of_ones(7)
mylist = [1,624,1107,8742,4401,8641,1111,6978,377,7694,3554,9193,7644,7403,5311,6631]




for item in mylist:
    print(number_of_ones(item))