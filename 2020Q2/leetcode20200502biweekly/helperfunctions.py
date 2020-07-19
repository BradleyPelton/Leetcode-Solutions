
def make_smaller(num):
    num_as_str = str(num)
    print(num_as_str)

    if num_as_str[0] == '1':
        # find the first digit not equal to 0 and replace it with 0
        for digit in num_as_str[1:]:
            if digit != '0':
                # print(digit)
                first_non_zero = digit
                # print(digit)
                break
        num_after_smallest = num_as_str.replace(str(first_non_zero), '1')
        print(num_after_smallest)
    else:
        # if the first digit not 1, replace it with 1
        first_digit = num_as_str[0]
        num_after_smallest = num_as_str.replace(str(first_digit), '1')
        print(num_after_smallest)

    return(num_after_smallest)


def make_larger(num):
    num_as_str = str(num)
    print(num_as_str)

    if num_as_str[0] == '9':
        # find the first digit not equal to 9 and replace it with 0
        for digit in num_as_str[1:]:
            if digit != '9':
                # print(digit)
                first_non_nine = digit
                break
        num_after_largest = num_as_str.replace(str(first_non_nine), '9')
        print(num_after_largest)
    else:
        # if the first digit not 1, replace it with 1
        first_digit = num_as_str[0]
        num_after_largest = num_as_str.replace(str(first_digit), '9')
        print(num_after_largest)

    return(num_after_largest)


# make_larger(make_larger(123))
# make_smaller(123456)
make_smaller(113456)
# make_smaller(make_smaller(321))
