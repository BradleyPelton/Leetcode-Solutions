def has_left_neighbor(s,i):
    """ string s, index i"""
    if i <= 0:
        return(False)
    return(True)

def has_right_neight(s,i):
    """string s, index i"""
    if i < len(s)-1:
        return(True)
    return(False)


a = 'hello world'
for i in range(len(a)):
    print(has_left_neighbor(a,i),has_right_neight(a,i),a[i])
