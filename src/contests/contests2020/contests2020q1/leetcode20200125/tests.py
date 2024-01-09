def isPalindrome(s):
    h = s[::-1]
    if s == h:
        return(True)
    return(False)




print(isPalindrome("abba"))

print(isPalindrome("abbbbb"))

print(isPalindrome("aaaaaa"))

print(isPalindrome("abbab"))
print(isPalindrome("bbbbbb"))

