from collections import deque
class Solution:
    def removePalindromeSub(self, s: str) -> int:
        """ fuck this is crazy"""

        if len(s) == 0:
            print(0)
            return(0)

        # Famous leet code problem... I think its actually the first problem???
        def longestPalindrome(s: str) -> str:
            if type(s) != str:
                s = "".join(s)
            m = ''  # Memory to remember a palindrome
            for i in range(len(s)):  # i = start, O = n
                for j in range(len(s), i, -1):  # j = end, O = n^2
                    if len(m) >= j-i:  # To reduce time
                        break
                    elif s[i:j] == s[i:j][::-1]:
                        m = s[i:j]
                        break
            return m

        copy = deque(s)
        print(copy)
        counter = 0 



        for _ in range(1000):
            temp = deque(longestPalindrome(copy))
            counter += 1
            print('temp is',temp)
            for _ in range(len(temp)):
                popped = temp.popleft()
                copy.remove(popped)
            print(copy)

            if len(copy) == 0:
                break
        print(counter)
        return(counter)






a = Solution()
# a.removePalindromeSub('ababa')
# a.removePalindromeSub('abb')
# a.removePalindromeSub('')
# a.removePalindromeSub('baabb')
a.removePalindromeSub("bbaabaaa")


