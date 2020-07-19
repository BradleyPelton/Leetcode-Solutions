from itertools import combinations

def combo_sums(numlist, c):
    """ return a list of values who are the sum of c number of numbers in numlist"""
    comb_list = combinations(numlist, c)
    comb_sums = [sum(comb) for comb in comb_list]
    return list(set(comb_sums))


print(combo_sums([1, 1, 2, 3, 5, 8, 13], 3))