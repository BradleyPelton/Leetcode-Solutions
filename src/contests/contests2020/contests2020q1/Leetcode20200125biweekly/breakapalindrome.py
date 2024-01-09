from collections import deque
class contests2020q4.leetcode20201017.Solution:
    def breakPalindrome(self, palindrome: str) -> str:
        copy = deque(palindrome)

        def isAllA(mystring):
            mydeque = deque(mystring)
            print(mydeque)
            while 'a' in mydeque:
                mydeque.remove('a')
            if len(mydeque) ==0:
                return(True)
            else:
                return(False)

        if len(palindrome) == 1:
            return("")
        if palindrome == 'aa':
            return('ab')
        if isAllA(palindrome):
            palindrome = palindrome[:len(palindrome)-2] +'b'
            print(palindrome)
            return(palindrome)


        def bothleftandrightA(mydeq):
            left = mydeq.popleft()
            right = mydeq.pop()
            if left == right and left == 'a':
                return(True)
            return(False)

        while len(copy) > 1:
            if bothleftandrightA(copy):
                copy.popleft()
                copy.pop()
                print(copy)
        print(copy)



a = contests2020q4.leetcode20201017.Solution()
a.breakPalindrome('abccba')
# # a.breakPalindrome('aaaaaa')
# a.breakPalindrome('aabaa')
