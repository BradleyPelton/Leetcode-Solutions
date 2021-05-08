
def valid_substring(s:str) -> bool:
    for char in ['a','e','i','o','u']:
        if s.count(char) % 2 == 1:
            print(char,s.count(char))
            return(False)
    return(True)

print(valid_substring('bcbcbc'))