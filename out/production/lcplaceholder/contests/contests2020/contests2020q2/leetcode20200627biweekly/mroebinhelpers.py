def all_one_substrings(binlist):
    """ return a list of tuples of the form (i,j) where [i:j] is a sublist of all '1's """
    
    all_substrings = []
    current_substring = tuple()

    for i in range(len(binlist)):
        if binlist[i] == 1:
            if current_substring == tuple():
                # create a new substring with start equal to i
                current_substring = (i,)
        
        elif binlist[i] == 0:
            if current_substring == tuple():
                pass
            else:
                # End a substring by 
                current_substring = (current_substring[0], i)
                all_substrings.append(current_substring)
                current_substring = tuple()
    if current_substring != tuple():
        # if the last substring didnt end, end it
        current_substring = (current_substring[0], len(binlist))
        all_substrings.append(current_substring)
        current_substring = tuple()
    
    print(all_substrings)
    return all_substrings

all_one_substrings([1,1,0,0,1,1,1,0,1])