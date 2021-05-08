import string

# HARD PROBLEM WORTH 8 POINTS
# NICE TO ATTEMPT, BUT PRETTY ADVANCED

class contests2020q4.leetcode20201017.Solution:
    def findGoodStrings(self, n: int, s1: str, s2: str, evil: str) -> int:
        alpha = string.ascii_lowercase



        def number_of_strings_between(s1,s2):
            """ number of strings, s, such that s1 <= s <= s2, and len(s)==n"""

            if s1 == s2:
                return(0)
            s_not_choices = alpha.index(s2[0]) - alpha.index(s1[0]))
            # NUMBER OF CHOICES BETWEEN a AND d,

                if s_not_choices == 0:
                    return(s1[1:],s2[1:])
                    pass
                elif s_not_choices == 1:
                    pass
                elif s_not_choices > 1:
                    count += 26*(s_not_choices-2)

                # WHEN s1[0] == s2[0], example sass, shzz
                    count += (alpha.index(s2[1]) -alpha.index(s1[1]))*26 
                    # number of characters between 's' and 'h'
                

            """ EVERYTHING BEFORE s[0]= s2[0] AND AFTER , has all possible choices"""

            # handles all of cases, just a guess at this point
            for i in range(0,len(s1)):
                count += 26*(alpha.index(s2[i])- alpha.index(s1[i]))






a = contests2020q4.leetcode20201017.Solution()
a.findGoodStrings(3,'aa','da','b')
