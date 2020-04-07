def divide_chunks(l, n): 
    # looping till length l 
    for i in range(0, len(l), n):  
        yield l[i:i + n] 


print(list(divide_chunks([1, 2, 3, 4, 5, 6, 7, 8, 9],3)))