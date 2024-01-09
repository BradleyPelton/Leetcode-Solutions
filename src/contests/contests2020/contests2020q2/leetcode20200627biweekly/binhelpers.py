def longest_substring_of_ones(binlist):
    current = 0
    highest = 0

    for num in binlist:
        if num == 1:
            current += 1
            if current > highest:
                highest = current
        else:
            current = 0
    # print(highest)
    return highest

# longest_substring_of_ones([1,0,1,1,1,1,0,1])
longest_substring_of_ones([0,1,1,1,0,1,1,0,1])