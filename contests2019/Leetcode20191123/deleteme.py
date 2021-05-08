
def search(list,keyword,n):
    key = keyword[0:n+1]
    copylist = list.copy()

    for word in list:
        if word[0:n+1] != key:
            copylist.remove(word)
    return copylist

a = ["mobile","mouse","moneypot","monitor","mousepad"]
b = "mouse"

print(search(a,b,0))