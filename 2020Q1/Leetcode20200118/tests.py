def equalLenth(mylist):
    """mylist is a list of strings"""

    lengths = [len(obj) for obj in mylist]
    greatest = max(lengths)

    print(greatest)

    copy = []
    for obj in mylist:
        while len(obj) < greatest:
            obj += ' '
            print(obj, len(obj))
        copy.append(obj)
    print(copy)

equalLenth(['a','bc','cde'])