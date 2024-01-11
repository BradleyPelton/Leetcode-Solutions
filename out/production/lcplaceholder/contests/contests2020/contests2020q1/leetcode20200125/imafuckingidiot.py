def isPalindrome(s):
    h = s[::-1]
    if s == h:
        return(True)
    return(False)

from collections import deque
class contests2020q4.leetcode20201017.Solution:
    def removePalindromeSub(self, s: str) -> int:
        """ fuck this is crazy"""
        def isPalindrome(s):
            h = s[::-1]
            if s == h:
                return(True)
            return(False)
        
        if len(s) == 0:
            return(0)
        elif isPalindrome(s):
            return(1)
        else:
            return(2)
        
