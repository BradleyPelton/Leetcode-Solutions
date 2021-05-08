from collections import Counter
def is_palindromable(nodelist):
    """return true if list can be converted to a palindrome"""
    # palindrome iff Counter(nodelist) contains only one odd
    node_counter = Counter(nodelist)

    num_of_odds = 0
    for key in node_counter.keys():
        if node_counter[key] % 2 == 1:
            num_of_odds += 1

    if len(nodelist) % 2 == 0:
        if num_of_odds > 0:
            return False
        else:
            return True
    elif len(nodelist) % 2 == 1:
        if num_of_odds > 1:
            return False
        else:
            return True

print(is_palindromable([2,3,3]))
print(is_palindromable([2,3,1]))
# print(is_palindromable('abaababa'))
# print(is_palindromable('aaabb'))
# print(is_palindromable('aaabbccd'))
# print(is_palindromable('abcba'))

