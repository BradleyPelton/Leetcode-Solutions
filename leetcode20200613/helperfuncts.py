def possible_boq(bool_list , k):
    """Return the number of bouquets, OF SIZE k, can be made from bool_list"""
    bool_string = ''
    for flower in bool_list:
        bool_string += str(flower)
    # print(bool_string)
    ones = bool_string.split('0')
    # print(ones)

    good_boqs = 0
    for subset in ones:
        good_boqs += len(subset) // k
    # print(good_boqs)
    return good_boqs

possible_boq([1,1,1,1,0,0,1,0,1,1,1,0,0,1], 2)