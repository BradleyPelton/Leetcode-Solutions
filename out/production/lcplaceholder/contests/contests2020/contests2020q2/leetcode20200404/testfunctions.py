def construct_optimal_string(a,b,c):

    alphabet = [('a', a), ('b', b), ('c',c)]
    alphabet.sort(key=lambda x: x[1])
    print(alphabet)




# construct_optimal_string(1,1,7)
# construct_optimal_string(1,0,5)





def within_two(a,b,c):
    if a-b <= 2 and b-a <=2  and a-c <= 2 and c-a <= 2 and b-c <= 2 and c-b <=2:
        return(True)
    else:
        return(False)


# within_two(1,1,1)
# within_two(1,10,1)
within_two(1,4,2)