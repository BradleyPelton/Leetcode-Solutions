from collections import Counter
class contests2020q4.leetcode20201017.Solution:
    def findTheLongestSubstring(self, s: str) -> int:
        
        def valid_substring(s:str) -> bool:
            for char in ['a','e','i','o','u']:
                if s.count(char) % 2 == 1:
                    return(False)
            return(True)
        
        def has_left_neighbor(s,i):
            """ string s, index i"""
            if i <= 0:
                return(False)
            return(True)

        def has_right_neight(s,i):
            """string s, index i"""
            if i < len(s)-1:
                return(True)
            return(False)

        if valid_substring(s):
            return(len(s))

        longest = ''
        # for i in range(len(s)):
            # I cant iterate over each element. There are too many combinations of substrings

        # [0,0,0,0,0'a',0,0,0,0,'e',0,0,0,0,0,0,0,'e',0,0,0,0,0,'o',0,0,0,0,0,'a']
        # what if I index every vowel, and add that index to a breakpoint list
        # the density of the voewls in english language, approximately 1/3 of letters are vowels
        # I would choose the breakpoints that are the furthest way apart and iterate of the breakpoints 
        # working my way from the outside in 

        # Issue #1: There would be A LOT of breakpoints. if len(s) <= 5 * 10**5, then len(breakpoints) ~= 1.3 * 10**5

        ################################################
        # different attempt

        potential_answer_string = s
        vowels = ['a','e','i','o','u']
        for vowel in vowels:
            if valid_substring(potential_answer_string):
                return(len(potential_answer_string))
            else:
                if potential_answer_string.count(vowel) % 2 == 1:
                    # we remove the right most occurence of vowel
        

        
a = contests2020q4.leetcode20201017.Solution()